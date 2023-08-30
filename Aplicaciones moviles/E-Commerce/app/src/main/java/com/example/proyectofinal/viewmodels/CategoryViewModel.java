package com.example.proyectofinal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.proyectofinal.connection.CategoryRepository;
import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.User;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private CategoryRepository repository;
    private LiveData<List<Category>> allCategorys;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        repository = new CategoryRepository(application);
        allCategorys = repository.getAllCategories();
    }

    public void insert(Category category) {
        repository.insert(category);
    }

    public void update(Category category) {
        repository.update(category);
    }

    public void delete(Category category) {
        repository.delete(category);
    }

    public void deleteById(int a_id) {
        repository.deleteById(a_id);
    }

    public void deleteAllCategories() {
        repository.deleteAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategorys;
    }

    public LiveData<Category> getCategoryByName(String name) {
        return repository.getSingleCategory(name);
    }
    public LiveData<Category> getCategoryById(int id) {
        return repository.getSingleCategoryById(id);
    }
}