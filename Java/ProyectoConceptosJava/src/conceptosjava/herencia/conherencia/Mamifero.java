/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.herencia.conherencia;

import java.util.Date;

/**
 *
 * @author vacax
 */
public class Mamifero extends SerVivo {

    //propiedades.
    int cantidadHuesos;
    int mamarios;
    Date fechaNacimiento;
    //¿especie?.
    //¿sangre caliente?.
    
    
    //operaciones:
    public void amamantar() {
        System.out.println("....");
    }

    public void darALuz() {
        System.out.println(".....");
    }

    @Override
    public void nacer() {
        super.nacer(); //
        System.out.println("Naciendo un mamifero...");
    }
    
    

}
