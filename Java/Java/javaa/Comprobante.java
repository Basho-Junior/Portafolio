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
public class Comprobante{
    private String tipo;
    private int numero;
    private Fecha fecha;


   
    public Comprobante(String ta, int no, Fecha fe){
     this.tipo = ta;
     this.numero = no;
     this.fecha = fe;
 }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
}

  