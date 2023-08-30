/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.interfaz.coninterfaz;


/**
 *
 * @author vacax
 */
public class Cientifico extends Ciudadano implements ISoldado, ITrabajor{
    
    String especialidad;
    
    public void pensar(){
        System.out.println("Pensando...");
    }
    
    public void crear(){
        System.out.println("Crear...");
    }

    @Override
    public void pelear() {
        System.out.println("Peleando...");
    }

    @Override
    public void marchar() {
        System.out.println("Marcheando... Clase: "+getClass().getSimpleName());
    }

    @Override
    public void entrenar() {
        System.out.println("Entrenando....");
    }

    @Override
    public void metodo() {
        System.out.println("Otro metodo....");
    }

    @Override
    public void trabajar() {
       System.out.println("Trabajando... Clase: "+getClass().getSimpleName()); 
    }
}
