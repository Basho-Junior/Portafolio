package com.example.practica11.entidades.repositorios;

import com.example.practica11.entidades.MockEndpoint;
import com.example.practica11.entidades.composite.MockEndpointPK;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface MockEndpointRepo extends CrudRepository<MockEndpoint, MockEndpointPK> {
    public void deleteAllByExpirationLessThan(Timestamp now);
}
