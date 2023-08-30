package com.example.practica3;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "mis_productos")
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private Double price;
    private String images;

    public Product(String name, String description, Double price, String images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}