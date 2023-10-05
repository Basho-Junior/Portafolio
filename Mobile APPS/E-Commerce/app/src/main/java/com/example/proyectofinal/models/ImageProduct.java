package com.example.proyectofinal.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "PRODUCT_IMAGE")
public class ImageProduct implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int tableid;

    @ColumnInfo(name = "ProductImageId")
    private String id;

    @ColumnInfo(name = "ProductId")
    private int ProductId;

    public ImageProduct(String id, int productId) {
        this.id = id;
        ProductId = productId;
    }

    public ImageProduct() {

    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }
}
