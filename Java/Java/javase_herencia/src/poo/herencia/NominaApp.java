package poo.herencia;

import java.util.Scanner;
import java.util.Date;

/**
 * 
 * @author 
 */
public class NominaApp{
    
    public void imprimirNomina(){
      Empleado empleado = new Empleado("Martin Jaquez", "Catcher", "Moca", new Date());   
      empleado.setPreciosHorasExtras(300);
      empleado.setSueldoFijo(5000);
      empleado.setHorasExtras(14);
      System.out.println("Nombre: "+empleado.getNombre() + " Sueldo: "+empleado.calcularSueldo());
     
      Consultor cons = new Consultor("Eduardo Roque", "QlikView Consultor", "Santiago", new Date());
      cons.setHoraTrabajadas(40);
      cons.setPrecioHoras(2000);
      System.out.println("Nombre: "+ cons.getNombre() + " Sueldo: "+ cons.calcularSueldo());
       
    
 }
    
public static void main(String[] args) {
       NominaApp sc = new NominaApp();
       sc.imprimirNomina();  
    }
}
