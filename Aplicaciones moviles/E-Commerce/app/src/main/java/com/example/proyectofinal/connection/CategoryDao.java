package com.example.proyectofinal.connection;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.User;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("DELETE FROM CATEGORY")
    void deleteAllCategories();

    @Query("DELETE FROM CATEGORY WHERE CategoryId = :id")
    void deleteById(int id);

    @Query("SELECT * FROM CATEGORY ORDER BY CategoryId DESC")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * FROM CATEGORY WHERE CategoryName = :name")
    LiveData<Category> getCategory(String name);

    @Query("SELECT * FROM CATEGORY WHERE CategoryId = :id")
    LiveData<Category> getCategoryByID(int id);

}