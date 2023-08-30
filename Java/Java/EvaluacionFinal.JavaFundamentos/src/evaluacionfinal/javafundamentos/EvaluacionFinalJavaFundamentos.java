
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal.javafundamentos;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author junio
 */
public class EvaluacionFinalJavaFundamentos {

    /**
     * @param nom
     * @param num
     * @param cedu
     * @param dire
     * @param tele
     * @param fecnaci
     * @param feccontra
     * @param puesto
     */
    public static void puestos(String nom,int num, String cedu, String dire,String tele,String fecnaci,Date feccontra, String puesto) {
        Scanner sc = new Scanner(System.in);
        switch (puesto) {
                case "SECRETARIO":
                case "SECRETARIA":
                case "Secretario":
                case "secretaria":
                case "secretario":
                case "Secretaria":
                  System.out.println("Ingrese horas trabajadas: ");
                  int o = sc.nextInt();
                  if (o > 44){
                  int horas = o - 44;
                  double n = Puesto.Secretaria.getSueldo();
                  double afp = 0.0272 * n;
                  double ars = 0.0301 * n;
                  double l = n - (afp + ars);
                  Empleado empleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
                  empleado.setPreciosHorasExtras(200);
                  empleado.setSueldoFijo(l);
                  empleado.setHorasExtras(horas);
                  System.out.println("Distinguido "+empleado.getNombre() + " su sueldo sera de "+empleado.calcularSueldo());
                  break;
                 
                  } 
                  if (o <= 0){
                 System.out.println("Usted no ha trabajado");
                 break;
                 }
                  else {
                  System.out.println("Lo siento pero para que se le sume a su salario debe de ser mas de 44 horas");
                  double n = Puesto.Secretaria.getSueldo();
                  double afp = 0.0272 * n;
                  double ars = 0.0301 * n;
                  double l = n - (afp + ars);
                  Empleado empleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
                  empleado.setPreciosHorasExtras(0);
                  empleado.setSueldoFijo(l);
                  empleado.setHorasExtras(0);
                  System.out.println("Distinguido "+empleado.getNombre() + " su sueldo sera de "+empleado.calcularSueldo());
                  break;
                  }
                  
              case "CONTABLE":
              case "contable": 
              case "Contable":
              System.out.println("Ingrese horas trabajadas: ");
              int pl = sc.nextInt();
              if (pl > 44){
              int horas = pl - 44;
              double m = Puesto.Contable.getSueldo();
              double cafp = 0.0272 * m;
              double cars = 0.0301 * m;
              double lo = m - (cafp + cars);
              Empleado cempleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
              cempleado.setPreciosHorasExtras(200);
              cempleado.setSueldoFijo(lo);
              cempleado.setHorasExtras(horas);
              System.out.println("Distinguido "+cempleado.getNombre() + " su sueldo sera de "+cempleado.calcularSueldo());
              break;
              
              } 
              if (pl <= 0){
                 System.out.println("Usted no ha trabajado");
                 break;
                 }
              else{
              
              System.out.println("Lo siento pero para que se le sume a su salario debe de ser mas de 44 horas");
              double m = Puesto.Contable.getSueldo();
              double cafp = 0.0272 * m;
              double cars = 0.0301 * m;
              double lo = m - (cafp + cars);
              Empleado cempleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
              cempleado.setPreciosHorasExtras(0);
              cempleado.setSueldoFijo(lo);
              cempleado.setHorasExtras(0);
              System.out.println("Distinguido "+cempleado.getNombre() + " su sueldo sera de "+cempleado.calcularSueldo());
              break;
              }
              case "CHOFER":
              case "chofer":
              case "Chofer":
              System.out.println("Ingrese horas trabajadas: ");
              int ll = sc.nextInt();
              if (ll > 44){
              int horas = ll - 44;
              double h = Puesto.Chofer.getSueldo();
              double chafp = 0.0272 * h;
              double chars = 0.0301 * h;
              double lol = h - (chafp + chars);
              Empleado chempleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
              chempleado.setPreciosHorasExtras(200);
              chempleado.setSueldoFijo(lol);
              chempleado.setHorasExtras(horas);
              System.out.println("Distinguido "+chempleado.getNombre() + " su sueldo sera de "+chempleado.calcularSueldo());
              break;
              }
              if (ll <= 0){
                 System.out.println("Usted no ha trabajado");
                 break;
                 }
              else{
              System.out.println("Lo siento pero para que se le sume a su salario debe de ser mas de 44 horas");
              double h = Puesto.Chofer.getSueldo();
              double chafp = 0.0272 * h;
              double chars = 0.0301 * h;
              double lol = h - (chafp + chars);
              Empleado chempleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
              chempleado.setPreciosHorasExtras(0);
              chempleado.setSueldoFijo(lol);
              chempleado.setHorasExtras(0);
              System.out.println("Distinguido "+chempleado.getNombre() + " su sueldo sera de "+chempleado.calcularSueldo());
              break;
              }
              case "COORDINADOR":
              case "COORDINADORA":
              case "coordinador":
              case "Coordinadora":
              case "coordinadora":
              case "Coordinador":
              System.out.println("Ingrese horas trabajadas: ");
              int kk = sc.nextInt();
              if (kk > 44){
              int horas = kk - 44;
              double v = Puesto.Coordinador.getSueldo();
              double coafp = 0.0272 * v;
              double coars = 0.0301 * v;
              double lolo = v - (coafp + coars);
              Empleado coempleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra, puesto);
              coempleado.setPreciosHorasExtras(200);
              coempleado.setSueldoFijo(lolo);
              coempleado.setHorasExtras(horas);
              System.out.println("Distinguido "+coempleado.getNombre() + " su sueldo sera de "+coempleado.calcularSueldo());
              break;
              }
              if (kk <= 0){
                 System.out.println("Usted no ha trabajado");
                 break;
                 }
              else{
              double v = Puesto.Coordinador.getSueldo();
              double coafp = 0.0272 * v;
              double coars = 0.0301 * v;
              double lolo = v - (coafp + coars);
              Empleado coempleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
              coempleado.setPreciosHorasExtras(0);
              coempleado.setSueldoFijo(lolo);
              coempleado.setHorasExtras(0);
              System.out.println("Distinguido "+coempleado.getNombre() + " su sueldo sera de "+coempleado.calcularSueldo());
              break;
              }
            case "director":
            case "directora":
            case "Directora":
            case "Director":
            System.out.println("Ingrese horas trabajadas: ");
            int ddl = sc.nextInt();
            if (ddl <= 0){
            System.out.println("Usted no ha trabajado");
            break;
            }
            else{
            double d = Puesto.Director.getSueldo();
            double dafp = 0.0272 * d;
            double dars = 0.0301 * d;
            double dl = d - (dafp + dars);
                  Empleado dempleado = new Empleado(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
                  dempleado.setPreciosHorasExtras(0);
                  dempleado.setSueldoFijo(dl);
                  dempleado.setHorasExtras(0);
                  System.out.println("Distinguido "+dempleado.getNombre() + " su sueldo sera de "+dempleado.calcularSueldo());
                  break;
            }
            case "pasante":
            case "Pasante":
                System.out.println("Bienvenido " + nom + " como pasante debemos de cubrir los gastos de su pasaje y de su dieta");
                System.out.println("De cuanto es el pasaje: ");
                double r = sc.nextDouble();
                System.out.println("De cuanto es su dieta ");
                double b = sc.nextDouble();
                Pasante nasa = new Pasante(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
                nasa.setPasaje(r);
                nasa.setDieta(b);
                double s = nasa.calcularSueldo();
                System.out.println("Su total de gastos es de " + s);
                while (s > 6000){
                    System.out.println("Lo siento esta fuera del rango \nSi desea puede volver a calcular o puede retirarse \n1 = Si 2 = No ");
                    int ty = sc.nextInt();
                    if (ty == 1){
                    System.out.println("De cuanto es el pasaje: ");
                    r = sc.nextDouble();
                    System.out.println("De cuanto es su dieta ");
                    b = sc.nextDouble();
                    nasa.setPasaje(r);
                    nasa.setDieta(b);
                    s = nasa.calcularSueldo();
                    if (ty == 2){
                    System.out.println("Lo lamentamos ");
                    System.exit(0);
                    }
                    }
                }
                System.out.println("Esta en nuestro rango");
                break;
            case "consultor":
            case "Consultora":
            case "consultora":
            case "Consultor":
                System.out.println("Ingrese las horas en que va a trabajar: ");
                double re = sc.nextDouble();
                if (re <= 0){
                System.out.println("Usted no ha trabajado");
                break;
                }
                else {
                Consultor c = new Consultor(nom,num,cedu,dire,tele,fecnaci,feccontra,puesto);
                c.setHoraTrabajadas(re);
                c.setPrecioHoras(1000);
                System.out.println("Distinguido "+c.getNombre() + " su sueldo sera de "+c.calcularSueldo());
                break;
                }
               
    }
     
    }

    
    
    public static void main(String[] args) {
       List <Persona>personas=new ArrayList<>();
       Map<String,String>mapPersonas=new HashMap<String,String>();
      System.out.println("Bienvenidos a nuestro software");
      Scanner sc = new Scanner(System.in);
      String decision = "s";
      int num = 1;
      while (decision.equalsIgnoreCase("s")) {
      num = num + 1;
      System.out.println("\n1 = Lista de empleados 2 = Registrase 3 = Salir");
      int a = 0;
      try{
      a = sc.nextInt();
      }catch (InputMismatchException e){
            System.out.println("Lo siento pero no es valido");
           sc.next();
        }
      if (a == 1){
      for(Map.Entry cal : mapPersonas.entrySet()){
      System.out.println(cal.getValue().toString());            
        }
          }
      if (a == 2){
          System.out.print("Ingrese su nombre: ");
          String nom = sc.next();
          sc.nextLine();
          System.out.print("Ingrese su cedula: ");
          String cedu = sc.nextLine();
          System.out.print("Ingrese direccion: ");
          String dire = sc.nextLine();
          System.out.print("Ingrese su numero telefonico: ");
          String tele = sc.nextLine();
          System.out.print("Ingrese su fecha de nacimiento: ");
          String fecnaci = sc.nextLine();
          Date feccontra = new Date();
          System.out.println("Ingrese su puesto: ");
          System.out.println("Secretari@" + "\nContable" + "\nCoordinador" + "\nChofer" + "\nDirector" + "\nConsultor" + "\nPasante");
          String pues = sc.nextLine();
          personas.add(new Persona(nom,num,cedu,dire,tele,fecnaci,feccontra,pues) {});
          
          for (Persona x: personas){
            String llave;
            int indice = personas.indexOf(x);
            String m = "\nNombre: " + x.getNombre() + "\nNumero: " + x.getNum_empleado() + "\nCedula: " + x.getCedula() + "\nDireccion: " + x.getDireccion() + "\nNumero telefonico: " + x.getTelefono() + "\nFecha de nacimiento: " + x.getFecha_naci()+ "\nFecha de contratacion: " + x.getFecha_conta() + "\nPuesto: " + x.getPuesto();
            llave = indice + x.getNombre() + x.getNum_empleado();
            mapPersonas.put(llave, m);
            }
            System.out.println("Desea revisar cual será salario? 1 = Si 2 = No");
            int o = sc.nextInt();
            if (o == 1){
            puestos(nom,num,cedu,dire,tele,fecnaci,feccontra,pues);
            }
            if (o == 2){
            continue;
            }
          }
      if (a == 3){
      System.out.println("Gracias por su visita");
      System.exit(0);
      }
    System.out.print("Quieres volver repetir el programa? (s/n): ");
    decision = sc.next();
    num = num +1;
    if ("n".equals(decision)){
    System.exit(0);
    }   
      }
      }   
      }
      
    

