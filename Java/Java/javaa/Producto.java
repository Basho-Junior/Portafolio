/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa;

/**
 *
 * @author junio
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private float precio;

    public Producto(int cod, String val, float n){
    this.codigo = cod;
    this.descripcion =val ;
    this.precio = n;
 }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
