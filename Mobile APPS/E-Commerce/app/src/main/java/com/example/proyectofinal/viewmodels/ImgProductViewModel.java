package com.example.proyectofinal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.proyectofinal.connection.ImgProductRepository;
import com.example.proyectofinal.models.ImageProduct;
import com.example.proyectofinal.models.User;

import java.util.ArrayList;
import java.util.List;

public class ImgProductViewModel extends AndroidViewModel {
    private ImgProductRepository repository;
    private LiveData<List<ImageProduct>> allImageProducts;

    public ImgProductViewModel(@NonNull Application application) {
        super(application);
        repository = new ImgProductRepository(application);
        allImageProducts = repository.getAllImages();
    }

    public void insert(ImageProduct ImageProduct) {
        repository.insert(ImageProduct);
    }

    public void update(ImageProduct ImageProduct) {
        repository.update(ImageProduct);
    }

    public void delete(ImageProduct ImageProduct) {
        repository.delete(ImageProduct);
    }

    public void deleteById(int a_id) {
        repository.deleteById(a_id);
    }

    public void deleteAllImageProducts() {
        repository.deleteAllImages();
    }

    public LiveData<List<String>> getImages(int id) {
        return repository.getImages(id);
    }

    public LiveData<List<ImageProduct>> getAllImageProducts() {
        return allImageProducts;
    }
}