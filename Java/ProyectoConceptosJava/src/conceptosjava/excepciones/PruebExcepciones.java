/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vacax
 */
public class PruebExcepciones {

    public static void main(String[] args) {
        File archivo = new File("/home/vacax/Descargas/borrame//hola.txt");
        try {
            RandomAccessFile accessFile = new RandomAccessFile(archivo, "rw");
            //si existe una excepcion, las siguientes lineas no se muestran...
            System.out.println("Archivo abierto...");
            accessFile.writeBytes("Hola Mundo en Java :-D \n");
            agregarLinea(accessFile, "Otra linea");
            accessFile.close();            
            System.out.println("Cerrando el archivo....");
        } catch (FileNotFoundException e) {
            System.out.println("El Archivo no existe...");
            e.printStackTrace();
        } catch (NullPointerException e) { //mas de un bloque..
            System.out.println("Capturando la excepcion de null....");
        } catch (IOException e) { //mas de un bloque..
            System.out.println("Problema con el archivo...");
            e.printStackTrace();
        } finally {
            //siempre se ejecuta con o sin excepcion...
            System.out.println("Ejecuntado en el bloque finally...");
        }       
        
        
        try {
            new Estudiante("123123", "Carlos Camacho");
        } catch (MatriculaInvalidaPucmmException ex) {
            System.out.println("Error en matrícula...");            
            ex.printStackTrace();
        }

    }
    
    public static void agregarLinea(RandomAccessFile af, String linea) 
            throws IOException{
        
        af.writeBytes(linea+"\n");
    }
}
