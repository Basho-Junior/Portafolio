package com.example.practica3;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("DELETE FROM mis_productos")
    void deleteAllNotes();

    @Query("DELETE FROM mis_productos WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT * FROM mis_productos ORDER BY id DESC")
    LiveData<List<Product>> getAllProducts();
}