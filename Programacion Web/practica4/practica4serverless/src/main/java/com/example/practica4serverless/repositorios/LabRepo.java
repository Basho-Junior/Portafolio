package com.example.practica4serverless.repositorios;

import com.example.practica4serverless.entidades.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabRepo extends JpaRepository<Laboratorio, Integer> {
    public Laboratorio findLaboratorioByNombre(String nombre);
    public Laboratorio findById(int id);
}
