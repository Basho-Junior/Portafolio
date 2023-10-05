package com.example.proyectofinal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.proyectofinal.connection.UserRepository;
import com.example.proyectofinal.models.CarItem;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData<List<User>> allUsers;
    private User auth;
 //   ArrayList<CarItem> carItems;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }

    public void insert(User user) {
        repository.insert(user);
        System.out.println("se inserto");
    }

/*    public ArrayList<CarItem> getCarItems() {
        return carItems;
    }

    public void setCarItems(Product product, int cant) {
        CarItem carItem =new CarItem(product,cant);
        carItems.add(carItem);
    }*/

    public void update(User user) {
        repository.update(user);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public void deleteById(int a_id) {
        repository.deleteById(a_id);
    }

    public void deleteAllUsers() {
        repository.deleteAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<User> getSingleUser(String mail) {
        return repository.getSingleUser(mail);
    }

    public LiveData<User> getSingleUserByUsername(String usernmae) {
        return repository.getSingleUserByUsername(usernmae);
    }

    public LiveData<User> getLiveData(String userEmail, String password) {
        return repository.checkUser(userEmail, password);
    }
    public User getAuth() {
        return auth;
    }

    public void setAuth(User auth) {
        this.auth = auth;
    }


}