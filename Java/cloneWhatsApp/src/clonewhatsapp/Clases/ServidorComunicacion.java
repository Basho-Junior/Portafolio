/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clonewhatsapp.Clases;

import clonewhatsapp.clientGUI;
import clonewhatsapp.clientSignInGUI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorComunicacion implements Runnable {

    private static ServidorComunicacion instancia;
    static Socket p;
    private ServerSocket servidor;
    private List<ManejoComunicacion> listaManejoComunicacion = new ArrayList<>();
     private List<ManejoComunicacion> lista = new ArrayList<>();
    private boolean arrancado;
    private SubjectHelper subjectHelper = new SubjectHelper();
    public static Map<String, Socket> map = null;
    public static Vector<String> nombreUsuario = null;    // thread security
    public static ArrayList<Socket> listaUsuario = null;
    public static Socket r;
    

    private ServidorComunicacion() {
    }

    /**
     * @return
     */
    public static ServidorComunicacion getInstacia() {
        if (instancia == null) {
            instancia = new ServidorComunicacion();
        }
        return instancia;
    }

    /**
     * @param puerto
     * @throws Exception
     */
    public void iniciarServidor(int puerto) throws Exception {
        //instanciamos colecciones
        Socket r = new Socket();
        nombreUsuario = new Vector<String>();     
        map = new HashMap<String, Socket>();
        listaUsuario = new ArrayList<Socket>();
        //
        mostrarLog("Iniciando Servidor en puerto: " + puerto);
        servidor = new ServerSocket(puerto);
        mostrarLog("Servidor Inicializado...");
        arrancado = true;
        new Thread(this).start();
    }

    /**
     *
     */
    public void pararServidor() {
        mostrarLog("Parando el servidor");
        arrancado = false;
        try {
            servidor.close();
            servidor = null;
            listaManejoComunicacion.clear();
            subjectHelper.removeAllObserver();
        } catch (IOException ex) {
            Logger.getLogger(ServidorComunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensajeUsuariosConectados(Mensaje mensaje) throws IOException {
        if(mensaje.getMensaje().equals("")){
            return;
        }
    
        ManejoComunicacion m;
        ManejoComunicacion n;
        if(listaUsuario.contains(r)){
                m=new ManejoComunicacion(r);
                n=new ManejoComunicacion(p);
                System.out.println("Enviando mensaje a "+ mensaje.enviadoA);
                m.enviarInformacion(mensaje.getUsuario(), mensaje.getEnviadoA(), mensaje.getMensaje());
                n.enviarInformacion(mensaje.getUsuario(), mensaje.getEnviadoA(), mensaje.getMensaje());
       
        }
        
        /*
        for (ManejoComunicacion m : listaManejoComunicacion) {
            try {
                m.enviarInformacion(mensaje.getUsuario(), mensaje.getEnviadoA(), mensaje.getMensaje());
            } catch (IOException ex) {
                Logger.getLogger(ServidorComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
    }
   

    @Override
    public void run() {
        while(arrancado){
            try {
                
                // nombreUsuario = new Vector<String>();     
                // map = new HashMap<String, Socket>();    
                   
                //Abriendo el sockect.
                Socket s = servidor.accept();
                mostrarLog("Nuevo Cliente: "+s.getRemoteSocketAddress().toString());
                //
                subjectHelper.notify(ServerSocket.class, "nueva conexion", TipoNotificacion.CONEXION);
                //agregando la lista el socket nuevo.
                listaUsuario.add(s);
                //
                ManejoComunicacion r = new ManejoComunicacion(s);
                ManejoComunicacion m = new ManejoComunicacion(s,listaUsuario,nombreUsuario, map);
                //
                m.addObservadorListener((Class clase, Object argumento, Enum anEnum) -> {
                    subjectHelper.notify(clase, argumento, anEnum);
                });
                //
                lista.add(r);
                listaManejoComunicacion.add(m);   
                //Iniciando el hilo
                new Thread(m).start();
            } catch (IOException ex) {
                Logger.getLogger(ServidorComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 
     * @param observer
     */
    public void addObservadorListener(IObserver observer) {
        subjectHelper.addObserver(observer);
    }

    /**
     * 
     * @param observer
     */
    public void removeObservadorListener(IObserver observer) {
        subjectHelper.removeObserver(observer);
    }

    /**
     * @param log
     */
    private void mostrarLog(String log) {
        System.out.println(log);
        subjectHelper.notify(ServidorComunicacion.class, log, TipoNotificacion.LOG);
    }
}
