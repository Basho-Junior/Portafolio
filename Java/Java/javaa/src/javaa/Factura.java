/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa;

import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class Factura extends Comprobante{
    private ArrayList<Producto> mProducto;
    private float total;
    private Cliente mCliente;
    
    public Factura(String tipo, int numero, Fecha fecha, int dia, int mes, int anio) {
        super(tipo, numero, fecha, dia, mes, anio);
    }

    
    public ArrayList<Producto> getmProducto() {
        return mProducto;
    }

    public void setmProducto(ArrayList<Producto> mProducto) {
        this.mProducto = mProducto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getmCliente() {
        return mCliente;
    }

    public void setmCliente(Cliente mCliente) {
        this.mCliente = mCliente;
    }
    
    
  
    
}
