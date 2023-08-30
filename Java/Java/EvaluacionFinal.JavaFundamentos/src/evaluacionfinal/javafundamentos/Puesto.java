/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal.javafundamentos;

/**
 *
 * @author junio
 */
public enum Puesto implements Sueldo{
    Secretaria(15000),Contable(25000),Chofer(18000),Coordinador(35000),Director(55000);

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    double sueldo;

    private Puesto(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public double calcularSueldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

