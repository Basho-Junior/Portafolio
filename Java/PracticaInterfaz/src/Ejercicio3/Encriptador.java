/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author Junior
 */
public class Encriptador implements IAlgoritmo {
    static int num;
    String tipo;

    public Encriptador(String tip) {
        this.tipo = tip;
    }

    @Override
    public int encriptar(int num) {
        if("Diferencia".equals(this.tipo))
        {
            return num + num;
        }else if("Multiplicacion".equals(this.tipo))
        {
            return num * num;
        }
        return 0;
    }

    @Override
    public int desencriptar(int num) {
        return num;
    }
}
