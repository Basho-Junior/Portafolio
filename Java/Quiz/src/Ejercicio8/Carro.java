/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

/**
 *
 * @author Junior
 */
public class Carro {

    private motor Motor;
    private String Marca;
    private String Modelo;
    private double Precio;

    public Carro(String marca, String modelo) {
        Marca = marca;
        Modelo = modelo;
        Motor = new motor(0);
    }

    public motor getMotor() {
        return Motor;
    }
    
    public void setMotor(motor motor) {
        this.Motor = motor;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public double getPrecioAverias() {
        return Precio;
    }

    public void AcumuladoAverias(double valorAveria) {
        this.Precio += valorAveria;
    }
    
    public void MostrarCarro() {
        System.out.println("Marca: " + this.Marca + "\nModelo: " + this.Modelo);
        System.out.println("Precio Averia: " + this.Precio + "\nAceite: " + this.Motor.getAceite());
    }
}
