/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.modificadores.clases;

/**
 *
 * @author vacax
 */
// no tiene sentido el private para clase con nombre del archivo.
// en clases del primer orden.
public class ModificadorPrivado { 

    public ModificadorPrivado() {
        new ClasePrivada().test();
    }

    //clase interna.... 
    private class ClasePrivada {// si puedo tener una privada.
        public void test(){
            System.out.println("Desde la clase interna: "+this.getClass().getName());
        }    
    }
}
