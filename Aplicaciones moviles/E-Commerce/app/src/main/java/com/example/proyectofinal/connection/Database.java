package com.example.proyectofinal.connection;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.proyectofinal.models.CarItem;
import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.ImageProduct;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.models.User;

@androidx.room.Database(entities = {Product.class, Category.class, User.class, ImageProduct.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract ProductDao productDao();
    public abstract UserDao userDao();
    public abstract CategoryDao categoryDao();
    public abstract ImgProductDao imgProductDaoDao();

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                     Database.class, "ECOMERCE.DB")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProductDao productDao;

        private PopulateDbAsyncTask(Database db) {
            productDao = db.productDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }


}