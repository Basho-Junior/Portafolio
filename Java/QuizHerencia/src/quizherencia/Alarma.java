/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherencia;

/**
 *
 * @author Junior
 */
public class Alarma {
    private int minimo;
    private Timbre timbre;
    private int maximo;
    
    public Alarma(int min, int max)
    {
        this.minimo = min;
        this.maximo = max;
        timbre = new Timbre();
    }
    
    public void chequeo(int real)
    {
        if(real < minimo || real > maximo)
        {
            timbre.activar("Sonido activado");
        }else
        {
            timbre.activar("Sonido desactivado");
        }
    }
    
}


