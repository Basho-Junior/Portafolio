/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaaula;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author junio
 */
public class Ordenar {
    public static void main(String[] args) {
        Integer[] enteros ={10,20,50,100,75,35,67,1};
        List<Integer> lista = Arrays.asList(enteros);
        Collections.sort(lista);
        Collections.reverse(lista);
        for (int neh : lista) {
            System.out.println(neh);
        }

    }
    
}
