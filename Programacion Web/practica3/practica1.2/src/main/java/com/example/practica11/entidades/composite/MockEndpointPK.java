package com.example.practica11.entidades.composite;

import com.example.practica11.utilidades.MockEndpointMethods;

import java.io.Serializable;
import java.util.Objects;


public class MockEndpointPK implements Serializable {
    private String proyectoId;
    private String path;
    private MockEndpointMethods method;

    public MockEndpointPK() {
    }

    public MockEndpointPK(String proyectoId, MockEndpointMethods method, String path) {
        this.proyectoId = proyectoId;
        this.method = method;
        this.path = path;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MockEndpointMethods getMethod() {
        return method;
    }

    public void setMethod(MockEndpointMethods method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MockEndpointPK that = (MockEndpointPK) o;
        return Objects.equals(proyectoId, that.proyectoId) && Objects.equals(path, that.path) && method == that.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyectoId, path, method);
    }
}
