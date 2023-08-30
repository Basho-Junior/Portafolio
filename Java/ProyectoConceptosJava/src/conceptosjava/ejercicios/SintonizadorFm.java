/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.ejercicios;

/**
 *
 * @author vacax
 */
public class SintonizadorFm {
    
    //Constantes final si son primitivo debo inicialiar al momento
    // de declarar.
    public static final double INCREMENTO = 0.5;
    public static final double MINIMO = 80.0;
    public static final double MAXIMA = 108.0;
    
    //Constante tipo objetos.
    public static final Estudiante MIESTUDIANTE  = new Estudiante();
    public final Estudiante MIESTUDIANTE2; //puedo dar valor en el constructor.
    
    //
    private double dial = MINIMO;
    
    public SintonizadorFm(){
       MIESTUDIANTE2 = new Estudiante(); 
       //NO puedo moficiar el valor de las constantes primitiva
       //MAXIMA = 12;
       //puedo cambiar los atributos o propiedades..
       MIESTUDIANTE.setMatricula(20011136);
       //NO puedo cambair la referencia.
       //Estudiante otro = new Estudiante();
       //MIESTUDIANTE =  MIESTUDIANTE2;
       //MIESTUDIANTE = otro;
       
    }
    
    public void up(){
        dial+=INCREMENTO;
        if(dial > MAXIMA){
            dial = MINIMO;
        }
    }
    
    public void down(){
       dial-=INCREMENTO;
        if(dial < MINIMO){
            dial = MAXIMA;
        } 
    }
    
    public double getDial(){
        return dial;
    }
    
    public static void main(String[] args) {
        SintonizadorFm fm = new SintonizadorFm();
        System.out.println("Dial actual: "+fm.getDial());
        fm.down();
        System.out.println("Dial actual: "+fm.getDial());
        fm.up();
        System.out.println("Dial actual: "+fm.getDial());
    }
    
}
