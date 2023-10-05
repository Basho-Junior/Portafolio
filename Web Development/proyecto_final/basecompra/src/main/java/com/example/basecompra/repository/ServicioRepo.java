package com.example.basecompra.repository;

import com.example.basecompra.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepo extends JpaRepository<Servicio, Long> {
}
