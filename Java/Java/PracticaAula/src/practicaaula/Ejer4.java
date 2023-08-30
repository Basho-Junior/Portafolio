/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaaula;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author junio
 */
public class Ejer4{
    public static void main(String[] args) {
List <Persona>personas=new ArrayList<>();
personas.add(new Persona("Rita","Perez",Genero.FEMENINO,15));
personas.add(new Persona("Maria","Rosa",Genero.FEMENINO,25));
personas.add(new Persona("Luz","Santos",Genero.FEMENINO,30));
personas.add(new Persona("Juan","Perez",Genero.MASCULINO,55));
personas.add(new Persona("Victor","Martinez",Genero.MASCULINO,32));
personas.add(new Persona("Rafael","Santos",Genero.MASCULINO,47));
personas.add(new Persona("Manuel","Cabral",Genero.MASCULINO,0));
personas.add(new Persona("Marta","Rodriguez",Genero.FEMENINO,18));
personas.add(new Persona("Andres","Jimenez",Genero.MASCULINO,52));
personas.add(new Persona("Hector","Perez", Genero.MASCULINO,51));
Map<String,String>mapPersonas=new HashMap<String,String>();
String llave; 

for (Persona x: personas){
    int indice = personas.indexOf(x);
    String m = "Nombre: " + x.getNombre() + " Apellido: " + x.getApellido() + " Genero: " + x.getGenero() + " Edad: " + x.getEdad();
    llave = indice + x.getNombre() + x.getApellido();
    mapPersonas.put(llave, m);
}
for(Map.Entry cal : mapPersonas.entrySet()){
            System.out.println(cal.getKey()+"  "+cal.getValue().toString());            
            
        }
}
}
    
