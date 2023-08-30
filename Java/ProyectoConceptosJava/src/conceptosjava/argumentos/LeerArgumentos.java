/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.argumentos;

/**
 * Clase para leer argumentos.
 * @author vacax
 */
public class LeerArgumentos {
    
    /**
     * El metodo main recibe un arreglo de String,
     * y representa información que es enviada una vez 
     * ejecutada la clase.
     * @param args 
     */
    public static void main(String[] args) {
        int cantidadParametros = args.length;
        System.out.println("Cantidad de parametros: "+cantidadParametros);
        
        //Iterando for normal.
        for(int i=0;i<cantidadParametros;i++){
            System.out.println("args["+i+"] = "+args[i]);
        }
        
        //iterando todos los parametros foreach:
        for(String argumento : args){
            System.out.println("Argumento: "+argumento);
        }
            
    }
}
