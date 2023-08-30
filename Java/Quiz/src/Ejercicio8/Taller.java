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
public class Taller{

    private Carro carro;
    private String tipoaveria;
    private int numcarro;
    private static int cantrep;

    public Taller() {
        this.carro = null;
        this.tipoaveria = "";
        this.numcarro = 0;
    }

    private boolean Atendiendo() {
        if (this.numcarro == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void AceptandoCarro(Carro car, String tipoAveria) {
        int litros;
        if (Atendiendo() == true) {
            System.out.println("Se puede atender su carro");
            this.carro = car;
            this.tipoaveria = tipoAveria;
            if (this.tipoaveria.equals("aceite")) {
                litros = this.carro.getMotor().getAceite();
                this.carro.getMotor().setAceite(litros + 10);
            }
            this.carro.AcumuladoAverias(Math.random() * 100);
            this.numcarro = 1;
        }else
        {
         System.out.println("No se puede atender su carro");   
        }
    }

    public void DevolviendoCoche() {
        this.numcarro = 0;
        cantrep ++;
        System.out.println("Carro devuelto");
    }
    public static int getreparos() {
        return cantrep;
    }
}
