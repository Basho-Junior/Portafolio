package com.example.practica3;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    private static ProductDatabase instance;

    public abstract ProductDao noteDao();

    public static synchronized ProductDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                     ProductDatabase.class, "Inventaria.db")
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

        private PopulateDbAsyncTask(ProductDatabase db) {
            productDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //productDao.insert(new Product(1,"Title 1", "Description 1", 2.50, ""));
            return null;
        }
    }
}