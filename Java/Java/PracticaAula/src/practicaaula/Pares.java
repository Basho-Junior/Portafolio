/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaaula;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author junio
 */
public class Pares {
    public static void main(String[] args) {
    List<String> lista = Arrays.asList("Edificio","Casa","Escuela","Apartamento","Carro","Tienda","Farmacia","Supermercado","Plaza","Cine","Hotel");
              
   for (String sexto : lista) {
        int p = sexto.length();
        //Si lo quiere ver todos quite esto como comentario y ponga el if como uno: System.out.println(sexto + " " + p);
        if (p%2 == 0 ){
        Set <String> pares = new HashSet <String>();
        pares.add(sexto);
        System.out.println(pares);
        }
            }
    

        }
    }
