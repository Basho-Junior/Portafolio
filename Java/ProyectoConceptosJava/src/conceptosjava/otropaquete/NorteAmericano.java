/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.otropaquete;

import conceptosjava.herencia.conherencia.SerHumano;

/**
 *
 * @author vacax
 */
public class NorteAmericano extends SerHumano{
    
    public void metodo(){
        nacer(); //es publico.
        pensar(); // es protegido y permite verlo fuera del paquete.
        //trabajar(); // es predeterminadoo y no visualiza fuera del paquete.
        //metodoPrivador(); //metodo privado no viaja en la herencia.
        
        
    }
}
