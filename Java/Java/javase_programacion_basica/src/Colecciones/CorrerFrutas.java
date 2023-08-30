/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;
import java.util.Scanner;
/**
 *
 * @author junio
 */
public class CorrerFrutas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String decision = "s";
        System.out.println("Debe escribir la fruta con la primera letra en mayusculas");
   while (decision.equalsIgnoreCase("s")){
        System.out.println("Inserte la fruta aqui: ");
        String ju = sc.nextLine();
        switch (ju) {
            case "Mango":
        System.out.println(" "+Frutas.MANGO.getDescripcion());
        break;
        
            case "Naranja":
        System.out.println(" "+Frutas.NARANJA.getDescripcion());
        break;
        
            case "Melon":
        System.out.println(" "+Frutas.MELON.getDescripcion());
        break;
        
            case "Zapote":
        System.out.println(" "+Frutas.ZAPOTE.getDescripcion());
        break;
     
            case "Sandia":
        System.out.println(" "+Frutas.SANDIA.getDescripcion());
        break;
        
            default:
        System.out.println("Opción digitada no es válida");
        break;
    }
        Scanner sp = new Scanner(System.in);
        System.out.print("Quiere volver repetir el programa? (s/n): ");
        decision = sp.next();
        if ("n".equals(decision)){
        System.exit(0);
  }
   }  
 }
}
