package Practica2.Entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private long id;
    private String nombreCliente;
    private ArrayList<Producto> listaProductos;
    private Date fecha;

    public Venta(long id, String nombreCliente, ArrayList<Producto> listaProductos) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.listaProductos = listaProductos;
        this.fecha = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getFecha() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String temp = dateFormat.format(fecha);
        return temp;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal(){
        Integer total = 0;
        for (Producto producto : listaProductos) {
            total += producto.getPrecio()*producto.getCantidad();
        }
        return total;
    }
}
