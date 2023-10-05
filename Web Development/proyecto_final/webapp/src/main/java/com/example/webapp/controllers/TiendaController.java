package com.example.webapp.controllers;

import com.example.webapp.utilities.ForSummary;
import com.example.webapp.utilities.RequestNewOrder;
import com.example.webapp.utilities.Servicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TiendaController.class);

    @Value("${applicacion.url}")
    String hostUrl;

    @Value("${proyecto.api.url}")
    String apiUrl;

    SimpleDateFormat inDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    SimpleDateFormat outDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("")
    public String tienda(Model model) {
        ResponseEntity<Servicio[]> response = restTemplate.exchange(
                apiUrl + "/api/ventas/servicios",
                HttpMethod.GET,
                null,
                Servicio[].class
        );
        if (response.hasBody()) {
            List<Servicio> servicios = Arrays.asList(response.getBody());
            model.addAttribute("servicios", servicios);
        }

        return "tienda";
    }

    @GetMapping("/evento/{id}")
    public String getServicio(Model model, @PathVariable("id") String id) {
        ResponseEntity<Servicio> response = restTemplate.exchange(
                apiUrl + "/api/ventas/servicios/" + id,
                HttpMethod.GET,
                null,
                Servicio.class
        );
        if (response.hasBody()) {
            Servicio servicio = response.getBody();
            model.addAttribute("servicio", servicio);
            model.addAttribute("hoy", inDateFormat.format(new Date()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no existe.");
        }

        return "summaryBefore";
    }

    @RequestMapping("/orden")
    public String orderPreview(
            Model model,
            @RequestParam(value = "token") String paypal_id,
            @RequestParam(value = "PayerID", required = false, defaultValue = "") String payer_id
    ) {
        ForSummary summary = restTemplate.exchange(
                apiUrl + "/api/ventas/order/paypal/" + paypal_id,
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders() {{
                    setBearerAuth(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
                }}),
                ForSummary.class
        ).getBody();
        model.addAttribute("servicio", summary.getServicio());
        model.addAttribute("fechaDue", summary.getFecha());
        model.addAttribute("paypalId", paypal_id);
        return "summaryAfter";
    }

    @PostMapping("/evento/{id}")
    public RedirectView createNewOrder(@PathVariable("id") String id, @RequestParam("fecha") String fecha) {
        String pFecha = null;
        try {
            pFecha = outDateFormat.format(inDateFormat.parse(fecha));
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
        HttpEntity<RequestNewOrder> requestBody = new HttpEntity(
                new RequestNewOrder(
                        Long.valueOf(id),
                        hostUrl + "/tienda/orden",
                        hostUrl + "/tienda/evento/" + id,
                        pFecha
                ),
                new HttpHeaders() {{
                    setBearerAuth(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
                }}
        );
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl + "/api/ventas/order",
                HttpMethod.POST,
                requestBody,
                String.class
        );
        if (!response.getStatusCode().equals(HttpStatus.OK))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hubo un problema.");
        return new RedirectView(response.getBody());
    }
}
