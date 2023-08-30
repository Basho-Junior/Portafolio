package com.example.basecompra.controllers;

import com.example.basecompra.models.Orden;
import com.example.basecompra.models.Servicio;
import com.example.basecompra.models.enumerate.OrdenStatus;
import com.example.basecompra.repository.OrdenRepo;
import com.example.basecompra.repository.ServicioRepo;
import com.example.basecompra.services.PaypalService;
import com.example.basecompra.utilities.ForSummary;
import com.example.basecompra.utilities.OrderList;
import com.example.basecompra.utilities.RequestNewOrder;
import com.example.basecompra.utilities.Resumen;
import com.example.basecompra.utilities.paypal.PaypalLinkDescription;
import com.example.basecompra.utilities.paypal.PaypalOrder;
import com.example.basecompra.utilities.paypal.PaypalPurchaseUnit;
import com.example.basecompra.utilities.paypal.PaypalPurchaseUnitItem;
import com.example.basecompra.utilities.paypal.enumerate.PaypalHttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ventas/order")
public class OrderController {

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private ServicioRepo servicioRepo;

    @Autowired
    private OrdenRepo ordenRepo;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @GetMapping(value = "/paypal/{id}")
    public ForSummary orden(@PathVariable String id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        PaypalOrder paypalOrder = paypalService.getPaypalOrderData(id);
        PaypalPurchaseUnit paypalPurchaseUnit = paypalOrder.getPurchaseUnits().stream().findFirst().get();
        PaypalPurchaseUnitItem item = paypalPurchaseUnit.getItems().stream().findFirst().get();
        if(!paypalPurchaseUnit.getCustom_id().equals(username))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Este no es su factura.");
        Servicio servicio = servicioRepo.findById(Long.valueOf(item.getSku())).get();
        String fecha = paypalPurchaseUnit.getDescription();
        return new ForSummary(servicio, fecha);
    }

    //crear una order, retorna un link para que sea redirecionado el usuario.
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createOrder(@RequestBody RequestNewOrder requestNewOrder) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Servicio> servicio = servicioRepo.findById(requestNewOrder.getServicioId());
        if (!servicio.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay servicios declarados.");
        }
        try {
            simpleDateFormat.parse(requestNewOrder.getDueDatetime());
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        List<Servicio> servicios = new ArrayList<>();
        servicios.add(servicio.get());
        PaypalOrder order = paypalService.createOrder(
                auth.getName(),
                requestNewOrder.getReturnUrl(),
                requestNewOrder.getCancelUrl(),
                servicios,
                requestNewOrder.getDueDatetime()
        );
        PaypalLinkDescription approveLink = order.getLinks().stream().filter(link -> link.getRel().equalsIgnoreCase("approve") && link.getMethod().equals(PaypalHttpMethod.GET)).findFirst().get();
        return approveLink.getHref();
    }

    @GetMapping("")
    public OrderList getList(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "status", required = false) OrdenStatus status
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Orden> ordenes = null;
        if (auth.isAuthenticated() && auth.getAuthorities().contains(new SimpleGrantedAuthority("ROL_CLIENTE"))) {
            String clienteUsername = auth.getName();
            if (status == null)
                ordenes = ordenRepo.findAllByClientUsername(clienteUsername, pageable);
            else
                ordenes = ordenRepo.findAllByClientUsernameAndStatus(clienteUsername, status, pageable);
        } else if (status != null && username != null) {
            ordenes = ordenRepo.findAllByClientUsernameStartsWithAndStatus(username, status, pageable);
        } else if (status != null && username == null)
            ordenes = ordenRepo.findAllByStatus(status, pageable);
        else if (status == null && username != null)
            ordenes = ordenRepo.findAllByClientUsernameStartsWith(username, pageable);
        else
            ordenes = ordenRepo.findAll(pageable).toList();
        return new OrderList(
                size,
                ordenes.size() / size + 1,
                ordenes
        );
    }

    @GetMapping("/{id}")
    public Orden getOrden(
            @PathVariable("id") Long id
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Orden> optional = null;
        if (auth.isAuthenticated() && auth.getAuthorities().contains("ROL_CLIENTE")) {
            String clienteUsername = auth.getName();
            optional = ordenRepo.findByIdAndClientUsername(id, clienteUsername);
        } else {
            ordenRepo.findById(id);
        }

        if (optional.isPresent())
            return optional.get();
        return null;
    }

    @PostMapping(value = "/{id}/accept")
    public Orden acceptOrder(
            @PathVariable("id") Long id
    ) {
        Optional<Orden> optional = ordenRepo.findByIdAndStatus(id, OrdenStatus.CREATED);
        if (optional.isPresent()) {
            Date date = new Date();
            Orden orden = optional.get();
            orden.setStatus(OrdenStatus.PROGRESS);
            orden.setAcceptedDate(date);
            orden.setUpdateDate(date);
            orden = ordenRepo.save(orden);
            return orden;
        }
        return null;
    }

    @PostMapping(value = "/{id}/complete")
    public Orden completeOrder(
            @PathVariable("id") Long id
    ) {
        //Todo: set employee username
        Optional<Orden> optional = ordenRepo.findByIdAndStatus(id, OrdenStatus.PROGRESS);
        if (optional.isPresent()) {
            Orden orden = optional.get();
            orden.setStatus(OrdenStatus.COMPLETED);
            orden.setUpdateDate(new Date());
            orden = ordenRepo.save(orden);
            return orden;
        }
        return null;
    }

    @PostMapping(value = "/resumen")
    public List<Resumen> getResumenes() {
        List<Resumen> resumenes = new ArrayList<>();
        Date hoy = Date.from(LocalDateTime.now().minusDays(6).atZone(ZoneId.systemDefault()).toInstant());
        Calendar c = Calendar.getInstance();
        c.setTime(hoy);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        for (int i = 0; i < 7; i++) {
            hoy = c.getTime();
            c.add(Calendar.DATE, 1);
            Date despues = c.getTime();
            resumenes.add(new Resumen(
                    ordenRepo.countAllByCreateDateBetween(hoy, despues),
                    ordenRepo.countAllByAcceptedDateBetween(hoy, despues),
                    ordenRepo.countAllByUpdateDateBetweenAndStatus(hoy, despues, OrdenStatus.COMPLETED),
                    hoy
            ));
        }
        return resumenes;
    }
}
