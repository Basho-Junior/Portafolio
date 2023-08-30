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
public class Comprobante extends Fecha{
    private String tipo;
    private int numero;
    private Fecha fecha;

    public Comprobante(int dia, int mes, int anio) {
        super(dia, mes, anio);
    }

    public Comprobante(String tipo, int numero, Fecha fecha, int dia, int mes, int anio) {
        super(dia, mes, anio);
        this.tipo = tipo;
        this.numero = numero;
        this.fecha = fecha;
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

  