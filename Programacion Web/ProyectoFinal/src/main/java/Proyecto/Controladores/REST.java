package Proyecto.Controladores;

import Proyecto.Entidades.Link;
import Proyecto.Entidades.Usuario;
import Proyecto.Services.ServiceLink;
import Proyecto.Services.ServiceUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class REST  {
    private static REST instance;
    private List<Usuario> usuarios = new ArrayList<>();

    public static REST getInstance(){
        if(instance==null){
            instance = new REST();
        }
        return instance;
    }

    public Usuario findUser(String usuario){
        List<Usuario> act =  ServiceUsuario.getInstancia().findAllByUsuario(usuario);
        if(act.size()==0){
            return null;
        }

        for (Usuario user: act
        ) {
            System.out.println(user.getUsuario());
        }
        return act.get(0);
    }

    public Set<Link> getUsuarios(String usuario){

        Usuario temp = findUser(usuario);
        if(temp == null)
        {
            System.out.println("No Existe el usuario: "+usuario);
        }
        return temp.getEnlaces();
    }

    public Link createLink(String url,String usuario) throws IOException {
        return linkMaker(ServiceLink.getInstancia().createEnlace(url,usuario));
    }

    public Link[] createArray(String user){
        Link[] enlaces = ServiceLink.getInstancia().getEnlaces(user);
        for(int i = 0; i < enlaces.length; i++){
            Link aux = linkMaker(enlaces[i]);
            enlaces[i] = aux;
        }
        return enlaces;
    }

    private Link linkMaker(Link enlace) {
        Link aux = new Link();
        aux.setId(enlace.getId());
        aux.setURL(enlace.getURL());
        aux.setFecha(enlace.getFecha());
        aux.setURLF(enlace.getURLF());
        aux.setVisitas(enlace.getVisitas());
        aux.setFotoBase64(enlace.getFotoBase64());
        aux.setVisitantes(aux.getVisitantes());
        return aux;
    }
}
