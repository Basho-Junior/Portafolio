package clonewhatsapp.Clases;

import clonewhatsapp.clientGUI;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Clase encargada de encapsular toda la comunicación de los clientes.
 */
public class ManejoComunicacion implements Runnable {

    //Propiedades
    private Socket socket;
    private ArrayList<Socket> listaUsuario;
    private Vector<String> nombreUsuario;
    private Map<String, Socket> map;
    private DataOutputStream enviarInformacion;
    private DataInputStream recibirInformacion;
    private Gson gson = new Gson();
    private SubjectHelper subjectHelper = new SubjectHelper();
    private clientGUI e;
    private boolean flag = true;
    private String receptor;
    public static boolean deci = true;
    private String usuario1 = "usuario1.dat";
    private String usuario2 = "usuario2.dat";
    private String usuario3 = "usuario3.dat";
    List<Mensaje> mensajes = new ArrayList<>();
    public static int i = 0;

    public ManejoComunicacion() {

    }

    public ManejoComunicacion(Socket s) throws IOException {
        this.socket = s;
        //Abriendo los flujos de datos.
        recibirInformacion = new DataInputStream(this.socket.getInputStream());
        enviarInformacion = new DataOutputStream(this.socket.getOutputStream());

    }

    public ManejoComunicacion(boolean decitumai) {
        this.deci = decitumai;
    }
//

    public void getRef(clientGUI e) {
        this.e = e;
    }

    /**
     *
     * @param socket
     * @throws IOException
     */
    public ManejoComunicacion(Socket socket, ArrayList<Socket> listaUsuario, Vector<String> nomeUsuario, Map<String, Socket> map) throws IOException {
        this.socket = socket;

        this.listaUsuario = listaUsuario;
        this.nombreUsuario = nomeUsuario;
        this.map = map;
        //Abriendo los flujos de datos.
        recibirInformacion = new DataInputStream(this.socket.getInputStream());
        enviarInformacion = new DataOutputStream(this.socket.getOutputStream());

    }

    /**
     *
     * @throws IOException
     */
    public void recibirInformacion() throws IOException {
        while (socket.isConnected()) {
            //recibiendo información 
            String mensaje = recibirInformacion.readUTF();
            Mensaje m = gson.fromJson(mensaje, Mensaje.class);
            //
            receptor = m.enviadoA;
            //Comprobando que el usuario que digite se enceuntra
            System.out.println("imprimiendo receptor del ciclo for: " + receptor);
            if (nombreUsuario.contains(receptor)) {
                //Ocultamos lado izquierdo
                clientGUI.setAddUser(deci);
            } else {
                System.out.println("No lo encontro...");
            }
            //
            mostrarLog("Mensaje Json Raw: " + mensaje);
            mostrarLog("Enviado por: " + "[" + m.getUsuario() + "]" + " a " + "[" + m.getEnviadoA() + "]" + " el mensaje: " + "[" + m.getMensaje() + "]");
            //
            System.out.println("usuario: " + m.getUsuario());
            System.out.println("Tama;p areglo " + nombreUsuario.size());
            String line = m.getUsuario();
            //
            if (!nombreUsuario.contains(line)) {
                System.out.println("toy dentro bb");
                //Agregamos nombre de usuario
                nombreUsuario.addElement(m.getUsuario());
                map.put(m.getUsuario(), socket);
                System.out.println("Tama;p areglo ahora " + nombreUsuario.size());
            }

            //enviar el mensaje a todos los clientes conectado.
            if (map.containsKey(m.enviadoA)&& map.containsKey(m.enviadoPor)) {
                System.out.println("Im in!");
                ServidorComunicacion.r = map.get(m.enviadoA);
                ServidorComunicacion.p = map.get(m.enviadoPor);
                System.out.println("Socket encontrado en map:¨" + map.get(m.enviadoA));
                socket = map.get(m.enviadoA);
            }
            ServidorComunicacion.getInstacia().enviarMensajeUsuariosConectados(m);

        }
    }

    

    public static boolean getDeci() {
        return deci;
    }

    /**
     * No es necesario tener en un hilo para enviar información.
     *
     * @param enviadoPor
     * @param mensajes
     * @throws IOException
     */
    public void enviarInformacion(String enviadoPor, String enviadoA, String mensajes) throws IOException {
        Mensaje m = new Mensaje(enviadoPor, enviadoA, mensajes, new Date());
        enviarInformacion.writeUTF(gson.toJson(m));
        enviarInformacion.flush();
    }

    @Override
    public void run() {
        try {
            recibirInformacion();
        } catch (EOFException ex) {
            mostrarLog("Flujo de datos cerrados.");
            subjectHelper.notify(ManejoComunicacion.class, "Desconectando", TipoNotificacion.DESCONEXION);
        } catch (IOException ex) {
            Logger.getLogger(ManejoComunicacion.class.getName()).log(Level.SEVERE, null, ex);
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
     *
     * @param log
     */
    private void mostrarLog(String log) {
        System.out.println(log);
        subjectHelper.notify(ManejoComunicacion.class, log, TipoNotificacion.LOG);
    }
}
