/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioshilos;

import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.logging.Level;


/**
 *
 * @author Junior
 */

public class claseContador extends Thread {
    JLabel etiquetacion;
    JLabel display;
    JButton inicio;
    
    public claseContador(JLabel cronometro, JLabel displ, JButton inicio) {
        this.etiquetacion = cronometro;
        this.display = displ;
        this.inicio = inicio;
    }

    public JLabel getEtiquetacion() {
        return etiquetacion;
    }

    public void setEtiquetacion(JLabel etiquetacion) {
        this.etiquetacion = etiquetacion;
    }

    public JLabel getDisplay() {
        return display;
    }

    public void setDisplay(JLabel display) {
        this.display = display;
    }

    public JButton getInicio() {
        return inicio;
    }

    public void setInicio(JButton inicio) {
        this.inicio = inicio;
    }
    
    @Override
    public void run() {
        try{
            while(jMicroOndas.Iniciar){
                Thread.sleep(1000);                
                ejecutarReloj();
            }
        }catch(Exception e){
        }
    }
    
    private void ejecutarReloj() {
        jMicroOndas.segundos--;
        
        if(jMicroOndas.segundos < 1){
            jMicroOndas.segundos = 59;
            if(jMicroOndas.minutos == 0 && jMicroOndas.detener == false){
                jMicroOndas.detener = true;
            }
            if(jMicroOndas.detener == true && jMicroOndas.minutos == 0){
            jMicroOndas.segundos = 0;    
            }
            
           if(jMicroOndas.detener==false){
                jMicroOndas.minutos--;
           }
        }
        
        if(jMicroOndas.minutos < 1){
            jMicroOndas.detener = true;
            jMicroOndas.minutos = 0;
             
        } 
          if(jMicroOndas.minutos <= 1 && jMicroOndas.detener == true){
            jMicroOndas.minutos = 0; 
            jMicroOndas.detener = false;
        }
        
        String textMin=""; 
        String textSeg="";
        
         if(jMicroOndas.minutos < 10){
              textMin= "0" + jMicroOndas.minutos;
         }else {            
              textMin=""+jMicroOndas.minutos;
         }   
       
         if(jMicroOndas.segundos < 10){
              textSeg= "0" + jMicroOndas.segundos;
         }else{
              textSeg=""+jMicroOndas.segundos;
         }
        
        String tiempo = textMin+ ":" +textSeg; 
        etiquetacion.setText(tiempo);
        
        if(jMicroOndas.Proceso == true && jMicroOndas.minutos < 1 && jMicroOndas.segundos < 2){
                reiniciarReloj(); 
        }
    }

    private void reiniciarReloj() {
         for(int i = 0; i < 1; i++){
                display.setBackground(Color.RED);
                    try {
                    Thread.sleep(500);
                    display.setBackground(Color.YELLOW);
                } catch (InterruptedException ex) {
                    Logger.getLogger(jMicroOndas.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
         if(jMicroOndas.Proceso == true && jMicroOndas.minutos == 0 && jMicroOndas.segundos == 0){
                jMicroOndas.Iniciar=false;
                jMicroOndas.Proceso=false;
                Toolkit.getDefaultToolkit().beep();
             try {
                 Thread.sleep(10000);
                 display.setBackground(Color.YELLOW);
             } catch (InterruptedException ex) {
                 Logger.getLogger(claseContador.class.getName()).log(Level.SEVERE, null, ex);
             }
            display.setBackground(Color.BLACK);
            inicio.setEnabled(true);
            
        }
        
    }
}
