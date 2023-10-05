package com.example.primerparcial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {
    private static final String TAG = "ProductViewModel";
    private MutableLiveData<List<Product>> mutableLiveData;

    public LiveData<List<Product>> getProductList() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            initProductList();
        }
        return mutableLiveData;
    }

    private void initProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("SAMSUNG 980", "SAMSUNG 980 PRO SSD 2TB PCle Gen 4 Gaming M 2 Internal Solid State Hard Touched", 219.99));
        mutableLiveData.setValue(productList);
    }

    public void deleteProduct(int position) {
        if (mutableLiveData.getValue() != null) {
            List<Product> movieList = new ArrayList<>(mutableLiveData.getValue());
            movieList.remove(position);
            mutableLiveData.setValue(movieList);
        }
    }

    public void addProduct(Product movie) {
        if (mutableLiveData.getValue() != null) {
            List<Product> movieList = new ArrayList<>(mutableLiveData.getValue());
            movieList.add(movie);
            mutableLiveData.setValue(movieList);
        }
    }
}
