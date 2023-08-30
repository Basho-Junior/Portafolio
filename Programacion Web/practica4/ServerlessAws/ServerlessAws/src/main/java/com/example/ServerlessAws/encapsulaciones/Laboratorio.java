package com.example.ServerlessAws.encapsulaciones;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="laboratorios")
public class Laboratorio {
    @DynamoDBHashKey(attributeName="id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "nombre")
    private String nombre;
    @DynamoDBAttribute(attributeName = "cantidadMaxima")
    private String cantidadMaxima;

    public Laboratorio() {
    }

    public Laboratorio(String nombre, String cantidadMaxima) {
        this.nombre = nombre;
        this.cantidadMaxima = cantidadMaxima;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(String cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }
}
