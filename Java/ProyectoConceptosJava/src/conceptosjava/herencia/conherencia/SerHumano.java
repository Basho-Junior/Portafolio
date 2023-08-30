/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.herencia.conherencia;

/**
 *
 * @author vacax
 */
public class SerHumano extends Mamifero{
 
    //Predeterminado se visualiza en herencia y dentro del paquete.
    String raza;
    String idioma;
    //Se visualiza en herencia y fuera del paquente.
    protected String nacionalidad;

    public SerHumano() {
    }
    
    public SerHumano(String nombre){
        super.nombre = nombre; //asignando el nombre a la propieda del padre.
    }
    
    /**
     * Solo se visualiza en herencia y fuera del paquete.
     */
    protected void pensar(){
        System.out.println("Pensando...");
    }
    
    /**
     * Solo se visualiza en herencia y dentro del paquete. 
     */
    void trabajar(){
        System.out.println("Trabajar...");
    }
    
    @Override
    public void nacer(){
        //Cambiando el comportamiento...
        super.nacer();        
        //añadiendo funcionalidad.
        System.out.println("Soy un Ser Humano y naci diferente..");
    }   
    
    
    /**
     * Agregando final no puedo sobre-escribir el metodo.
     */
    public final void compartir(){  
        //puedo llamar cualquier metodo del padre..
        super.darALuz();
        super.amamantar();
        //
        System.out.println("Ser Humano Compartiendo...");
    }
    
    /**
     * No viaja en la herencia.
     */
   private void metodoPrivador(){
       
   }
    
}
