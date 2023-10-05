package com.example.proyectofinal.connection;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.models.User;

import java.util.List;

public class CategoryRepository {
    private CategoryDao categoryDao;
    private LiveData<List<Category>> allCategories;

    public CategoryRepository(Application application) {
        Database database = Database.getInstance(application);
        categoryDao = database.categoryDao();
        allCategories = categoryDao.getAllCategories();
    }

    public void insert(Category category) {
        new InsertNoteAsyncTask(categoryDao).execute(category);
    }

    public void update(Category category) {
        new UpdateNoteAsyncTask(categoryDao).execute(category);
    }

    public void delete(Category category) {
        new DeleteCategoryAsyncTask(categoryDao).execute(category);
    }

    public LiveData<Category> getSingleCategory(String name){
        return categoryDao.getCategory(name);
    }

    public LiveData<Category> getSingleCategoryById(int id){
        return categoryDao.getCategoryByID(id);
    }

    public void deleteById(int a_id) {
        new deleteAsyncTask(categoryDao).execute(a_id);
    }

    public void deleteAllCategories() {
        new DeleteAllCategoriesAsyncTask(categoryDao).execute();
    }

    public LiveData<List<Category>> getAllCategories() {return allCategories;}

    private static class InsertNoteAsyncTask extends AsyncTask<Category, Void, Void> {
        private CategoryDao categoryDao;

        private InsertNoteAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Category, Void, Void> {
        private CategoryDao categoryDao;

        private UpdateNoteAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category...categories) {
            categoryDao.update(categories[0]);
            return null;
        }
    }

    private static class DeleteCategoryAsyncTask extends AsyncTask<Category, Void, Void> {
        private CategoryDao categoryDao;

        private DeleteCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.delete(categories[0]);
            return null;
        }
    }

    private static class DeleteAllCategoriesAsyncTask extends AsyncTask<Void, Void, Void> {
        private CategoryDao categoryDao;

        private DeleteAllCategoriesAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.deleteAllCategories();
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Integer, Void, Void> {
        private CategoryDao asyncTaskDao;

        deleteAsyncTask(CategoryDao a_dao) {
            asyncTaskDao = a_dao;
        }

        @Override
        protected Void doInBackground(final Integer... a_id) {
            asyncTaskDao.deleteById(a_id[0]);
            return null;
        }
    }
}