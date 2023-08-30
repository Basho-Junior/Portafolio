/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.herencia.conherencia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vacax
 */
public class MainConHerencia {
    
    public static void main(String[] args) {
        //
        Mamifero mamifero1 =new Mamifero();
        Mamifero mamifero2 =new Mamifero();
        SerHumano humano = new SerHumano();
        //
        mamifero1.nombre = "Mamifero 1";
        mamifero2.nombre = "Mamifero 2";
        
        humano.idioma = "Español";
        humano.nacionalidad = "Dominicano";
        humano.nombre = "Carlos Camacho";
        //
        mamifero1.nacer();
        mamifero2.nacer();
        humano.nacer();

        //
        Mamifero rm = humano;
        SerVivo sv = humano;
        
        //
        rm.nacer();
        sv.nacer();
        
        ArrayList lista = new ArrayList<SerVivo>();
        lista.add(mamifero1);
        lista.add(mamifero2);
        lista.add(humano);
        imprimirListaNombresSeresVivos(lista);
        
    }
    
    public static void imprimirListaNombresSeresVivos(List<SerVivo> lista){
        System.out.println("\nListando nombres en la lista:");
        for(SerVivo v :  lista){
            System.out.println("Clase Tipo de Clase: "+v.getClass().getSimpleName()+", nombre: "+v.nombre);
        }
    }
    
}
