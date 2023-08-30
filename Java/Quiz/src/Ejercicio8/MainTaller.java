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
public class MainTaller {
    public static void main(String[] args) {
        
         Taller taller = new Taller();
        
         Carro Carro1 = new Carro("Honda","Civic Sedán");
         Carro Carro2 = new Carro("Kia","Sorento");
         
         taller.AceptandoCarro(Carro1, "aceite");
         taller.AceptandoCarro(Carro2, "aceite");
         taller.DevolviendoCoche();
         
         taller.AceptandoCarro(Carro2, "Luz rota");
         taller.DevolviendoCoche();
         
         taller.AceptandoCarro(Carro2, "LLanta rota");
         taller.DevolviendoCoche();
         
         taller.AceptandoCarro(Carro1, "aceite");
         
         Carro1.MostrarCarro();
         Carro2.MostrarCarro();
         
         System.out.println ("Cantidad de reparos: " + Taller.getreparos());
    
    }
}