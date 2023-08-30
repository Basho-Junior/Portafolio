package com.example.practica11.entidades.repositorios;

import com.example.practica11.entidades.MockProyecto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MockProyectoRepo extends CrudRepository<MockProyecto, String> {

    public List<MockProyecto> findAllByUsuarioId(String usuarioId);

    public Boolean existsByIdAndUsuarioId(String id, String usuarioId);
}
