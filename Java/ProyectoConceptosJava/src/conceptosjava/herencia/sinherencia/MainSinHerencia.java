/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.herencia.sinherencia;

/**
 *
 * @author vacax
 */
public class MainSinHerencia {
    
    public static void main(String[] args) {
        AnimalSinHerencia animalSinHerencia = new AnimalSinHerencia();
        PerroSinHerencia perroSinHerencia = new PerroSinHerencia();
        //
        animalSinHerencia.alimertarse();
        perroSinHerencia.alimertarse();
        //no funciona por no existir una relación de clases.
        //animalSinHerencia = (AnimalSinHerencia) perroSinHerencia;
        
    }
}
