package com.example.proyectofinal.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "CATEGORY")
public class Category implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CategoryId")
    private int id;
    @ColumnInfo(name = "CategoryName")
    private String name;
    @ColumnInfo(name = "CategoryImage")
    private String image;

    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Category() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}


}
