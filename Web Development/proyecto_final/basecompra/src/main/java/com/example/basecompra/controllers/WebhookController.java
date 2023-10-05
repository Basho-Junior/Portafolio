package com.example.basecompra.controllers;

import com.example.basecompra.models.Orden;
import com.example.basecompra.models.Servicio;
import com.example.basecompra.repository.OrdenRepo;
import com.example.basecompra.repository.ServicioRepo;
import com.example.basecompra.services.NotificacionService;
import com.example.basecompra.services.PaypalService;
import com.example.basecompra.utilities.Notificacion;
import com.example.basecompra.utilities.paypal.PaypalOrder;
import com.example.basecompra.utilities.paypal.Webhook.PaypalEvent;
import com.example.basecompra.utilities.paypal.enumerate.PaypalOrderStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas/webhook")
public class WebhookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private ServicioRepo servicioRepo;

    @Autowired
    private OrdenRepo ordenRepo;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    NotificacionService notificacionService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @PostMapping(value = "/paypal", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void webhook(
            @RequestHeader("PAYPAL-AUTH-ALGO") String authAlgo,
            @RequestHeader("PAYPAL-CERT-URL") String certUrl,
            @RequestHeader("PAYPAL-TRANSMISSION-ID") String transmissionId,
            @RequestHeader("PAYPAL-TRANSMISSION-SIG") String transmissionSig,
            @RequestHeader("PAYPAL-TRANSMISSION-TIME") String transmissionTime,
            @RequestBody String data
        ) throws JsonProcessingException {
//        LOGGER.info(String.format("Headers: %s, %s, %s, %s, %s", authAlgo, certUrl, transmissionId, transmissionSig, transmissionTime));
//        LOGGER.info(new ObjectMapper().writeValueAsString(data));
        if(paypalService.verifyWebhookSignature(
                authAlgo,
                certUrl,
                transmissionId,
                transmissionSig,
                transmissionTime,
                data
        )) {
            PaypalEvent parseData = objectMapper.readValue(data, PaypalEvent.class);
            if(parseData.getEventType().equalsIgnoreCase("CHECKOUT.ORDER.APPROVED")) {
                Map<String, Object> resources = parseData.getResource();
                String order_id = (String) resources.get("id");
                Map<String, Object> purchase_unit = (Map<String, Object>) ((List<Object>) resources.get("purchase_units")).get(0);
                //free things???
                String referenceId = (String) purchase_unit.get("reference_id");
                Date date = null;
                try {
                    date = simpleDateFormat.parse((String)purchase_unit.get("description"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //el custom_id lo cojo para poner el usuario
                String user_id = (String) purchase_unit.get("custom_id");
                //lista de servicios
                List<Long> serviciosId = new ArrayList<>();
                for (Map<String, Object> item :
                        (List<Map<String, Object>>) purchase_unit.get("items")) {
                    serviciosId.add(Long.valueOf((String) item.get("sku")));
                }
                List<Servicio> servicios = servicioRepo.findAllById(serviciosId);

                BigDecimal total = servicios.stream().map(x -> x.getCosto()).reduce(BigDecimal.ZERO, BigDecimal::add);

                Orden orden = new Orden(
                        order_id,
                        date,
                        user_id,
                        servicios.get(0),
                        total
                );

                PaypalOrder postOrder = paypalService.captureOrderPayment(order_id);
                if(postOrder.getStatus().equals(PaypalOrderStatus.COMPLETED)) {
                    orden = ordenRepo.save(orden);
                    if(orden.getId()!=null) {
                        notificacionService.makeRequest("/api/auth/bot/orderReceived",
                                HttpMethod.POST, user_id, String.class);
                        notificacionService.makeRequest("/notificacion/guardar",
                                HttpMethod.POST, new Notificacion(0, "" + order_id,
                                        SecurityContextHolder.getContext().getAuthentication().getName(),
                                        new Date(), servicios.get(0).getNombre(), "Paquete aprovisionado"),Void.class);
                        LOGGER.info("Created an order successfully.");
                    }
                } else {
                    LOGGER.warn("An payment capture failed to complete.");
                }
            }
        } else {
            LOGGER.warn("Got an invalid paypal webhook call.");
        }
    }
}
