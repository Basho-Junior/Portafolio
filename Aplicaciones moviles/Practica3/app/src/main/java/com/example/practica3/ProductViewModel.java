package com.example.practica3;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repository;
    private LiveData<List<Product>> allProducts;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductRepository(application);
        allProducts = repository.getAllProducts();
    }

    public void insert(Product product) {
        repository.insert(product);
    }

    public void update(Product product) {
        repository.update(product);
    }

    public void delete(Product product) {
        repository.delete(product);
    }

    public void deleteById(int a_id) {
        repository.deleteById(a_id);
    }

    public void deleteAllNotes() {
        repository.deleteAllProducts();
    }

    public LiveData<List<Product>> getAllNotes() {
        return allProducts;
    }
}