package com.example.practica3;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {
    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;

    public ProductRepository(Application application) {
        ProductDatabase database = ProductDatabase.getInstance(application);
        productDao = database.noteDao();
        allProducts = productDao.getAllProducts();
    }

    public void insert(Product product) {
        new InsertNoteAsyncTask(productDao).execute(product);
    }

    public void update(Product product) {
        new UpdateNoteAsyncTask(productDao).execute(product);
    }

    public void delete(Product product) {
        new DeleteNoteAsyncTask(productDao).execute(product);
    }

    public void deleteById(int a_id) {
        new deleteAsyncTask(productDao).execute(a_id);
    }

    public void deleteAllProducts() {
        new DeleteAllNotesAsyncTask(productDao).execute();
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao productDao;

        private InsertNoteAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.insert(products[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao productDao;

        private UpdateNoteAsyncTask(ProductDao productDao) {
            this.productDao= productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.update(products[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao productDao;

        private DeleteNoteAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.delete(products[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProductDao productDao;

        private DeleteAllNotesAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productDao.deleteAllNotes();
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Integer, Void, Void> {
        private ProductDao asyncTaskDao;

        deleteAsyncTask(ProductDao a_dao) {
            asyncTaskDao = a_dao;
        }

        @Override
        protected Void doInBackground(final Integer... a_id) {
            asyncTaskDao.deleteById(a_id[0]);
            return null;
        }
    }
}