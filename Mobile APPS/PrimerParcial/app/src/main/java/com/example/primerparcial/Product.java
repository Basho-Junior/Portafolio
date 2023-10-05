package com.example.primerparcial;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Product {
    private String articulo;
    private String descripcion;
    private double precio;

    public Product(String articulo, String descripcion, double precio) {
        this.articulo = articulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }


    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Product{" +
                "articulo='" + articulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return articulo.equals(product.articulo) &&
                descripcion.equals(product.descripcion) &&
                precio == product.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(articulo, descripcion, precio);
    }

    public static DiffUtil.ItemCallback<Product> itemCallback = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getArticulo().equals(newItem.getArticulo());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.equals(newItem);
        }
    };

}
