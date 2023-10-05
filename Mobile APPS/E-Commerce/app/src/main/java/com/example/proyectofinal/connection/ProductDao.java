package com.example.proyectofinal.connection;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.proyectofinal.models.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("DELETE FROM PRODUCT")
    void deleteAllProducts();

    @Query("DELETE FROM PRODUCT WHERE ProductId = :id")
    void deleteById(int id);

    @Query("SELECT * FROM PRODUCT WHERE ProductId = :id")
    LiveData<Product> findById(int id);

    @Query("SELECT * FROM PRODUCT ORDER BY ProductId DESC")
    LiveData<List<Product>> getAllProducts();
}