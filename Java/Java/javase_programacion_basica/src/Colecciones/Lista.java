/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;
import java.util.List;
import java.util.Arrays;


/**
 *
 * @author junio
 */
public class Lista {
    public static void main(String[] args) {
    List <String> lista = Arrays.asList ( "Edificio", "Casa", "Escuela", "Apartamento", "Carro", "Tienda" ,"Farmacia" );
    for (String sexto : lista) {
        int p = sexto.length();
        //Si lo quiere ver todos quite esto como comentario y ponga el if como uno: System.out.println(sexto + " " + p);
        if (p%2 == 0 ){
        lista.remove(lista);
        System.out.println(sexto + " " + p);
        }
            }
    

        }
    }

   
