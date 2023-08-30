package com.example.proyectofinal.connection;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.proyectofinal.models.ImageProduct;
import com.example.proyectofinal.models.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ImgProductDao {

    @Insert
    void insert(ImageProduct img);

    @Update
    void update(ImageProduct img);

    @Delete
    void delete(ImageProduct img);

    @Query("DELETE FROM PRODUCT_IMAGE")
    void deleteAllImages();

    @Query("DELETE FROM PRODUCT_IMAGE WHERE ProductImageId = :id")
    void deleteById(int id);

    @Query("SELECT ProductImageId FROM PRODUCT_IMAGE  WHERE ProductId = :id")
    LiveData<List<String>> getImages(int id);

    @Query("SELECT * FROM PRODUCT_IMAGE ORDER BY ProductImageId DESC")
    LiveData<List<ImageProduct>> getAllImages();
}