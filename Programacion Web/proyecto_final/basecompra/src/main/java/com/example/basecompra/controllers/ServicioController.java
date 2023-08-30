package com.example.basecompra.controllers;

import com.example.basecompra.models.Servicio;
import com.example.basecompra.repository.ServicioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas/servicios")
public class ServicioController {

    @Autowired
    ServicioRepo servicioRepo;

    @GetMapping("")
    public List<Servicio> getList(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        return servicioRepo.findAll(PageRequest.of(page, size)).toList();
    }

    @PostMapping("")
    public Servicio createServicio(
            @RequestBody Servicio servicio
    ) {
        servicioRepo.save(servicio);
        return servicio;
    }

    @GetMapping("/{id}")
    public Servicio getServicio(
            @PathVariable("id") Long id
    ) {
        Optional<Servicio> optional = servicioRepo.findById(id);
        if (optional.isPresent())
            return optional.get();
        return null;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Servicio modifyServicio(
            @PathVariable("id") Long id,
            @RequestBody Servicio servicio
    ) {
        if (id != servicio.getId() || !servicioRepo.existsById(id))
            return null;
        servicioRepo.save(servicio);
        return servicio;
    }

    @DeleteMapping("/{id}")
    public void deleteService(
            @PathVariable("id") Long id
    ) {
        servicioRepo.deleteById(id);
        return;
    }


}
