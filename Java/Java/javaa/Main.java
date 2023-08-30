/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa;

/**
 *
 * @author junio
 */

import java.util.Scanner;
import javaa.Fecha;
import javaa.Producto;
import javaa.Cliente;
import javaa.Factura;
public class Main {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.println("Ingrese dia: ");
 int day = sc.nextInt();
 System.out.println("Ingrese mes: ");
 int me = sc.nextInt();
 System.out.println("Ingrese anio: ");
 int ye = sc.nextInt();
 Fecha hoy = new Fecha(day,me,ye);
 int cosprod = 0;
 cosprod ++;
 System.out.println("Ingrese producto: ");
 String prod = sc.next();
 System.out.println("Ingrese precio producto: ");
 float pres = sc.nextFloat();
 Producto pro1 = new Producto(cosprod, prod, (float) pres);
 System.out.println("Ingrese codigo: ");
 int pod = sc.nextInt();
 System.out.println("Ingrese nombre: ");
 String re = sc.next();
 Cliente cliente = new Cliente(pod, re);
 Factura f1 = new Factura("F", 1, hoy, cliente);
 f1.agregarProducto(pro1);
 f1.mostrar();
 }
} 