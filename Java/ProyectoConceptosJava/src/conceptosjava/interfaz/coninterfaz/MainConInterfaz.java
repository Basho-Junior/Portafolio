/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.interfaz.coninterfaz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vacax
 */
public class MainConInterfaz {
    
    public static void main(String[] args) {
        //Los objetos...
        Trabajador trabajador  = new Trabajador();
        Cientifico cientifico = new Cientifico();
        Soldado soldado = new Soldado();
        
        //
        //Cientifico c1 = trabajador;
        
        //
        ISoldado iSoldado = trabajador;
        iSoldado.marchar();
        iSoldado = cientifico;
        iSoldado.marchar();
        iSoldado = soldado;
        iSoldado.marchar();
        iSoldado.metodoImplementado();
        
        //
        ITrabajor iTrabajor  = soldado;
        iTrabajor.trabajar();
        iTrabajor = cientifico;
        iTrabajor.trabajar();        
        
        System.out.println(""+ISoldado.VALOR);
        //ISoldado.VALOR = "asdasd";
        
        //Objeto anonima...
        ITrabajor trabajorInterfaz = new ITrabajor(){
            @Override
            public void trabajar() {
                System.out.println("Implementando una clase anomima de ITrabajor");
            }            
        };
        
        trabajorInterfaz.trabajar();
        
        //ArrayList<ISoldado> listaSoldado = new ArrayList<>();
        List<ISoldado> listaSoldado = new ArrayList<>();
        listaSoldado.add(trabajador);
        listaSoldado.add(cientifico);
        listaSoldado.add(soldado);
        listarSoldados(listaSoldado);
    }
    
    /**
     * 
     * @param listaSoldado 
     */
    public static void listarSoldados(List<ISoldado> listaSoldado){
        System.out.println("Listado desde el metodo:");
        for(ISoldado s : listaSoldado){
            s.marchar();
        }
    }
}
