package Proyecto.ApiServices;

import Proyecto.Entidades.Link;
import Proyecto.Entidades.Visitante;
import Proyecto.Services.ServiceLink;
import Proyecto.Services.ServiceUsuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.io.IOException;

@WebService
public class JABON {
    private ServiceLink enlaceService = ServiceLink.getInstancia();
    private ServiceUsuario usuarioService = ServiceUsuario.getInstancia();

    @WebMethod
    public boolean autentificacion(String user,String password){
        return (usuarioService.autentificacion(user,password) != null)?true:false;
    }

    @WebMethod
    public Link[] getLinks(String user){
        return createArray(user);
    }

    @WebMethod
    public Link getLink(int enlace,String user){
        return generateLink(enlaceService.find(enlace));
    }

    @WebMethod
    public Link makeLink(String url,String usuario) throws IOException {
        return generateLink(ServiceLink.getInstancia().createEnlace(url,usuario));
    }

    @WebMethod
    public Visitante[] getVisitantes(int id){
        Link enlace = ServiceLink.getInstancia().find(id);
        return enlace.getVisitantes().toArray(new Visitante[enlace.getVisitantes().size()]);
    }

    public Link[] createArray(String user){
        Link[] enlaces = ServiceLink.getInstancia().getEnlaces(user);
        for(int i = 0; i < enlaces.length; i++){
            Link aux = generateLink(enlaces[i]);
            enlaces[i] = aux;
        }
        return enlaces;
    }
    private Link generateLink(Link enlace) {
        Link temp = new Link();
        temp.setId(enlace.getId());
        temp.setURL(enlace.getURL());
        temp.setFecha(enlace.getFecha());
        temp.setURLF(enlace.getURLF());
        temp.setVisitas(enlace.getVisitas());
        temp.setFotoBase64(enlace.getFotoBase64());
        temp.setVisitantes(temp.getVisitantes());
        return temp;
    }
}
