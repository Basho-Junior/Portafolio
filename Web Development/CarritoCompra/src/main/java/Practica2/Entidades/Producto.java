package Practica2.Entidades;

public class Producto {
    private int id;
    private  String nombre;
    private int precio;
    private int cantidad;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void actualizar(Producto producto) {
        this.nombre = producto.nombre;
        this.precio = producto.precio;
    }

    public int total(){
        return precio * cantidad;
    }

}
