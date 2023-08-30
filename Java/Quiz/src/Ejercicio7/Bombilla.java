/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

/**
 *
 * @author Junior
 */
public class Bombilla {
    public static boolean interruptorg = true;
    private static final boolean apagada = false;
    private static final boolean encendida = true;
    private boolean interruptor;
    private boolean estado;
    
    public Bombilla()
    {
        interruptor = false;
    }
    
    public void apagar()
    {
        interruptor = apagada;
    }
    public void encender()
    {
        interruptor = encendida;
    }
    
    public static void pressinterruptor()
    {
        if (interruptorg == true)
        {
            interruptorg = false;
        }
        else
        {
            interruptorg = true;
        }
    }
    
    public boolean estado()
    {
        if(interruptor == true && interruptorg == true)
        {
            estado = encendida;
        }
        else
        {
            estado = apagada;
        }
        return estado;
    }
    
    public String mostrarestado()
    {
        String state = null;
        if (estado() == encendida)
        {
            state = "encendida";
        }
        else if (estado() == apagada)
        {
            state = "apagada";
        }
        return state;
    }
}
