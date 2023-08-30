/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author Junior
 */
public class Jugador implements IBateadorBasico,ILanzadorBasico {
    private String nombre;
    private double peso;
    private String tamano;
    private String posicion;
    private double promedioBateo;
    private double efectividadLanzamientos;
    private int errores;

    public Jugador(String nombre, double peso, String tamano, String posicion, double promedioBateo, double efectividadLanzamientos, int errores) {
        this.nombre = nombre;
        this.peso = peso;
        this.tamano = tamano;
        this.posicion = posicion;
        this.promedioBateo = promedioBateo;
        this.efectividadLanzamientos = efectividadLanzamientos;
        this.errores = errores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getPromedioBateo() {
        return promedioBateo;
    }

    public void setPromedioBateo(double promedioBateo) {
        this.promedioBateo = promedioBateo;
    }

    public double getEfectividadLanzamientos() {
        return efectividadLanzamientos;
    }

    public void setEfectividadLanzamientos(double efectividadLanzamientos) {
        this.efectividadLanzamientos = efectividadLanzamientos;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    @Override
    public void conectarhit() {
        System.out.println("Dando un hit moderado");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando");
    }

    @Override
    public void lanzarrectas() {
        System.out.println("Lanzando un recta a 60 MPH");
    }
    
}
