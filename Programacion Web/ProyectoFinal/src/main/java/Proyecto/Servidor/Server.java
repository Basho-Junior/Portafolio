package Proyecto.Servidor;

import Proyecto.ApiServices.LinkService;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server {

    private static final int PORT = 8000;
    private io.grpc.Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(PORT).addService(new LinkService()).build().start();
    }

    public void blockunitlShutdown() throws InterruptedException{
        if (server == null){
            return;
        }
        server.awaitTermination();
    }
}
