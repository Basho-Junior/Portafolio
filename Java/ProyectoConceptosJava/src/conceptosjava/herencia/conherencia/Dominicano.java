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
public final class Dominicano extends SerHumano{
    
    public Dominicano(String nombre){
        super("Carlos Camacho");
        nacionalidad = "Dominicano";
        idioma = "Español";        
    }
    
    public void otroMetodo(){
        //super("nombre"); ///no puedo llamar el constructor del padre, fuera del constructor.
        
    }

//    /**
//     * No puedo sobre-escribir un metodo con final...
//     */
//    @Override
//    public void compartir() {
//        super.compartir(); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}
