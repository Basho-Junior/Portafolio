package com.example.proyectofinal.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "PRODUCT", foreignKeys = {
        @ForeignKey(entity = Category.class, parentColumns = "CategoryId", childColumns = "CategoryId")
},indices = {
        @Index("CategoryId")
}
)
public class Product implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ProductId")
    private int id;
    @ColumnInfo(name = "ProductName")
    private String name;
    @ColumnInfo(name = "ProductDescription")
    private String description;
    @ColumnInfo(name = "ProductPrice")
    private Double price;
    @ColumnInfo(name = "CategoryId")
    private int idCatedory;
    @ColumnInfo(name = "ProductImage")
    private String image;

    @Ignore
    private List<String> images;


    public Product() {
    }

    public Product(String name, String description, Double price, String image,int idCatedory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.idCatedory = idCatedory;
        this.images = new ArrayList<>();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdCatedory() {
        return idCatedory;
    }

    public void setIdCatedory(int idCatedory) {
        this.idCatedory = idCatedory;
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


    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

}
