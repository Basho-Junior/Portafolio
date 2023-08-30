package Proyecto.Services;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BootStrapServices {
    private static Server server;
    private static BootStrapServices instancia;

    public static BootStrapServices getInstancia(){
        if(instancia == null){
            instancia=new BootStrapServices();
        }
        return instancia;
    }

    public void startDB() {
        try {
            //Modo servidor H2.
            Server.createTcpServer("-tcpPort",
                    "9092",
                    "-tcpAllowOthers",
                    "-tcpDaemon",
                    "-ifNotExists").start();
            //Abriendo el cliente web. El valor 0 representa puerto aleatorio.
            String status = Server.createWebServer("-trace", "-webPort", "0").start().getStatus();
            //
            System.out.println("Status Web: "+status);
        }catch (SQLException ex){
            System.out.println("Problema con la base de datos: "+ex.getMessage());
        }
    }

    public static void stopDB() throws SQLException {
        if(server != null){
            server.stop();
        }
    }

    public void init(){
        startDB();
    }

}
