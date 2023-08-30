package com.example.proyectofinal.connection;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.proyectofinal.models.ImageProduct;
import com.example.proyectofinal.models.User;

import java.util.ArrayList;
import java.util.List;

public class ImgProductRepository {
    private ImgProductDao imgProductDao;
    private LiveData<List<ImageProduct>> allImages;

    public ImgProductRepository(Application application) {
        Database database = Database.getInstance(application);
        imgProductDao = database.imgProductDaoDao();
        allImages = imgProductDao.getAllImages();
    }

    public void insert(ImageProduct imageProduct) {
        new InsertImageProductAsyncTask(imgProductDao).execute(imageProduct);
    }

    public void update(ImageProduct imageProduct) {
        new UpdateImageProductAsyncTask(imgProductDao).execute(imageProduct);
    }

    public void delete(ImageProduct imageProduct) {
        new DeleteImageProductAsyncTask(imgProductDao).execute(imageProduct);
    }

    public void deleteById(int a_id) {
        new deleteAsyncTask(imgProductDao).execute(a_id);
    }

    public void deleteAllImages() {
        new DeleteAllImageProductsAsyncTask(imgProductDao).execute();
    }

    public LiveData<List<ImageProduct>> getAllImages() {
        return allImages;
    }

    public LiveData<List<String>> getImages(int id) {
        return imgProductDao.getImages(id);
    }

    private static class InsertImageProductAsyncTask extends AsyncTask<ImageProduct, Void, Void> {
        private ImgProductDao imgProductDao;

        private InsertImageProductAsyncTask(ImgProductDao imgProductDao) {
            this.imgProductDao = imgProductDao;
        }

        @Override
        protected Void doInBackground(ImageProduct...images) {
            imgProductDao.insert(images[0]);
            return null;
        }
    }

    private static class UpdateImageProductAsyncTask extends AsyncTask<ImageProduct, Void, Void> {
        private ImgProductDao imgProductDao;

        private UpdateImageProductAsyncTask(ImgProductDao imgProductDao) {
            this.imgProductDao = imgProductDao;
        }

        @Override
        protected Void doInBackground(ImageProduct... images) {
            imgProductDao.update(images[0]);
            return null;
        }
    }

    private static class DeleteImageProductAsyncTask extends AsyncTask<ImageProduct, Void, Void> {
        private ImgProductDao imgProductDao;

        private DeleteImageProductAsyncTask(ImgProductDao imgProductDao) {
            this.imgProductDao = imgProductDao;
        }

        @Override
        protected Void doInBackground(ImageProduct...images) {
            imgProductDao.delete(images[0]);
            return null;
        }
    }

    private static class DeleteAllImageProductsAsyncTask extends AsyncTask<Void, Void, Void> {
        private ImgProductDao imgProductDao;

        private DeleteAllImageProductsAsyncTask(ImgProductDao imgProductDao) {
            this.imgProductDao = imgProductDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            imgProductDao.deleteAllImages();
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Integer, Void, Void> {
        private ImgProductDao asyncTaskDao;

        deleteAsyncTask(ImgProductDao a_dao) {
            asyncTaskDao = a_dao;
        }

        @Override
        protected Void doInBackground(final Integer... a_id) {
            asyncTaskDao.deleteById(a_id[0]);
            return null;
        }
    }
}