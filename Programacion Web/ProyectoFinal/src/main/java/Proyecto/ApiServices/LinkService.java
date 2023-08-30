package Proyecto.ApiServices;

import Proyecto.Entidades.Link;
import Proyecto.Entidades.Visitante;
import Proyecto.Services.ServiceLink;
import Proyecto.Services.ServiceUsuario;
import enlacern.EnlaceRnGrpc;
import enlacern.EnlaceRnOuterClass;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkService extends EnlaceRnGrpc.EnlaceRnImplBase{
    private final ServiceLink enlaceService = ServiceLink.getInstancia();
    private final ServiceUsuario usuarioService = ServiceUsuario.getInstancia();

    public void autentificacion(EnlaceRnOuterClass.usuarioRequest request, StreamObserver<EnlaceRnOuterClass.usuarioResponse> responseObserver){
        boolean autentificar = (usuarioService.autentificacion(request.getUsuario(),request.getContrasenia()) != null) ? true:false;
        System.out.println(autentificar);
        responseObserver.onNext(EnlaceRnOuterClass.usuarioResponse.newBuilder().setOkey(autentificar).build());
        responseObserver.onCompleted();
    }
    public void makeLink(EnlaceRnOuterClass.linkRequest request, StreamObserver<EnlaceRnOuterClass.linkResponse> responseObserver){
        try {
            Link aux = enlaceService.createEnlace(request.getEnlace(),request.getUsuario());
            responseObserver.onNext(convertidor(aux));
            responseObserver.onCompleted();
        } catch (IOException e) {
            responseObserver.onError(e.getCause());
        }

    }

    public void getLink(EnlaceRnOuterClass.visitantesRequest request, StreamObserver<EnlaceRnOuterClass.linkResponse> responseObserver){
       Link enlace = enlaceService.find(request.getIde());
        if (enlace != null){
            responseObserver.onNext(convertidor(enlace));
            responseObserver.onCompleted();
        }else{
            System.out.println("No existe el enlace: " + request.getIde());

        }
    }
    public void getLinks(EnlaceRnOuterClass.enlace request,StreamObserver<EnlaceRnOuterClass.listaLink> responseObserver){
        Link[] enlaces = enlaceService.getEnlaces(request.getUser());
        List<EnlaceRnOuterClass.linkResponse> enlaceResponses = new ArrayList<>();
        for (Link e : enlaces){
            enlaceResponses.add(convertidor(e));
        }
        EnlaceRnOuterClass.listaLink build = EnlaceRnOuterClass.listaLink.newBuilder().addAllEnlace(enlaceResponses).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }
    public void getVisitantes(EnlaceRnOuterClass.visitantesRequest request, StreamObserver<EnlaceRnOuterClass.visitanteReponse> responseObserver){
        List<Visitante> visitantes = enlaceService.find(request.getIde()).getVisitantes();
        List<EnlaceRnOuterClass.visitante> visitantesRN = new ArrayList<>();

        for (Visitante e: visitantes){
            visitantesRN.add(convertirVisitante(e));
        }
        EnlaceRnOuterClass.visitanteReponse build = EnlaceRnOuterClass.visitanteReponse.newBuilder().addAllVisitantes(visitantesRN).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }

    private EnlaceRnOuterClass.visitante convertirVisitante(Visitante e) {
        return EnlaceRnOuterClass.visitante.newBuilder()
                .setFecha(e.getFecha().toString())
                .setIpaddress(e.getIpaddress())
                .setNavegador(e.getNavegador())
                .setSistema(e.getSistema())
                .build();
    }

    private EnlaceRnOuterClass.linkResponse convertidor(Link aux) {
        return EnlaceRnOuterClass.linkResponse.newBuilder()
                .setEid(aux.getId())
                .setUrl(aux.getURL())
                .setFecha(aux.getFecha().toString())
                .setAcortado(aux.getURLF())
                .setVisitas(aux.getVisitas())
                .setFoto(aux.getFotoBase64())
                .build();
    }
}
