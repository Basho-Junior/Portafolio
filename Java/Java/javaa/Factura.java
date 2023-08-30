/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author junio
 */
public class Factura extends Comprobante{
    private ArrayList<Producto> mProducto;
    private float total;
    private Cliente mCliente;

 public Factura(String a, int b, Fecha c, Cliente d){
 super(a,b,c);
 this.mCliente = d;
 }

    public void agregarProducto(Producto pro){
        try{
    mProducto.add(pro);
     setTotal(getTotal() + pro.getPrecio());
        }
        catch(NullPointerException e){
 System.out.println("Error al agrague el producto a la lista");
        }
    }
    public void mostrarProductos(){
 Iterator<Producto> iter = mProducto.iterator();
 while (iter.hasNext()) {
 Producto pro = iter.next();
 System.out.println(" El Codigo: "+ pro.getCodigo() +" La Descripcion: " + pro.getDescripcion() + " El Precio: " + pro.getPrecio());
 }
 }
 public void mostrar(){
 System.out.println("Tipo:"+ getTipo()+ " Número: "+ getNumero()+ " Fecha: " +getFecha().getDia() +" "+ getFecha().getMes() + " " + getFecha().getAnio());

 System.out.println("Cliente: " + getmCliente());
 System.out.println("Codigo: " +mCliente.getCodigo() + " Razon Social: " + mCliente.getRazonSocial());
 System.out.println("Productos: \n");
 mostrarProductos();
 System.out.println("Total: " + getTotal());
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
