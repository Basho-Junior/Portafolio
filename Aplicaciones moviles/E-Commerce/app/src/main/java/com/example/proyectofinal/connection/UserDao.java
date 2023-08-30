package com.example.proyectofinal.connection;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM USER_APP")
    void deleteAllUsers();

    @Query("DELETE FROM USER_APP WHERE UserId = :id")
    void deleteById(int id);

    @Query("SELECT * FROM USER_APP ORDER BY UserId DESC")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM USER_APP WHERE UserMail = :mail")
    LiveData<User> getAnUser(String mail);

    @Query("SELECT * FROM USER_APP WHERE UserUname = :username")
    LiveData<User> getAnUserByUsername(String username);


    @Query("SELECT * FROM USER_APP WHERE UserUname = :username or UserMail = :username and UserPassword = :password")
    LiveData<User> checkUser(String username, String password);
}