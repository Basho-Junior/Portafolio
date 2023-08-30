package com.example.proyectofinal.ui.notification;

import com.example.proyectofinal.models.CarItem;

import java.util.ArrayList;

public class NotificationItem {
    private ArrayList<CarItem> products;

    public NotificationItem(ArrayList<CarItem> products) {
        this.products = products;
    }

    public ArrayList<CarItem> getProducts() {
        return products;
    }
    public float getFinalTotal(){
        float total = 0;

        for (CarItem product :
                products) {
            total += product.getProduct().getPrice() * product.getQuantity();
        }
        return total;
    }
    public int getAmount(){
        int amount = 0;
        for(CarItem cartItem: products){
            amount += cartItem.getQuantity();
        }
        return amount;
    }
}
