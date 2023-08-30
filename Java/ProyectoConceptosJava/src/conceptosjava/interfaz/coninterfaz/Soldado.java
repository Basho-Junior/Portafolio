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
public class Soldado extends Ciudadano implements ISoldado, ITrabajor{
   
    String rango;
    
    @Override
    public void pelear(){
        System.out.println("Peleando...");
    }
    
    @Override
    public void entrenar(){
        System.out.println("Entrenado... Clase: "+getClass().getSimpleName());
    }

    @Override
    public void marchar() {
        System.out.println("Marcheando... Clase: "+getClass().getSimpleName());
    }

    @Override
    public void metodo() {
        System.out.println("Metodo...");
    }

    @Override
    public void trabajar() {
        System.out.println("Trabajando... Clase: "+getClass().getSimpleName());
    }
}
