package Proyecto.Services;

import Proyecto.main;
import Proyecto.Entidades.Link;
import Proyecto.Entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kong.unirest.Unirest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.Set;

public class ServiceLink extends ServicioDBS<Link>{

    private static ServiceLink instancia;

    private ServiceLink() {
        super(Link.class);
    }

    public static ServiceLink getInstancia(){
        if(instancia==null){
            instancia = new ServiceLink();
        }
        return instancia;
    }

    public static boolean verificarCod(String cod) {
        EntityManager em = getEntityManager();
        boolean res = false;
        try {
            Query query = em.createQuery("select e from Link e where e.URLF like :cod", Link.class);
            query.setParameter("cod",cod+"%");
            res = query.getResultList().isEmpty();
        } catch (Exception e) {
            res = true;
        }

        return res;
    }

    public List<Link> nativeConsult(){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from Enlace ", Link.class);

        List<Link> lista = query.getResultList();
        return lista;
    }

    public Set<Link> deleteByID(Integer actual, Set<Link> enlace)
    {
        for (Link actuall : enlace) {
            if(actuall.getId() == actual)
            {
                enlace.remove(actuall);
                return enlace;
            }
        }

        return null;
    }


    public Link findLink(String path) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select e from Link e where e.URLF like :cod" , Link.class);
        query.setParameter("cod","'%"+path+"%'");
        List<Link> enlaces  = query.getResultList();
        return enlaces.get(0);
    }


    public String getPreview(String url) {

        String response = Unirest.get("https://api.microlink.io?url="+url+"&screenshot=true&meta=false")
                .asJson().getBody().getObject().getJSONObject("data")
                .getJSONObject("screenshot").get("url").toString();

        try {
            java.net.URL aux = new URL(response);
            BufferedImage image = ImageIO.read(aux);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(image,"png",bos);
            response = Base64.getEncoder().encodeToString(bos.toByteArray());
        }catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String getAcortado() {
        boolean res = false;
        String cod = "";

        while(!res){
            cod = main.codeGenerator();
            res = instancia.verificarCod(cod);
        }
        return cod;
    }

    public Link[] getEnlaces(String user){
        Usuario usuario = ServiceUsuario.getInstancia().findAllByUsuario(user).get(0);
        Link[] enlaces = new Link[usuario.getEnlaces().size()];
        usuario.getEnlaces().toArray(enlaces);
        System.out.println(enlaces[0].getURL());
        return enlaces;
    }

    public Link createEnlace(String url,String usuario) throws IOException {
        System.out.println(usuario);
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        connection.disconnect();
        if (200 <= responseCode && responseCode <= 399 || responseCode == 403) {
            Link enlace = new Link();
            if(!usuario.equalsIgnoreCase("anonimo")) {
                Usuario user = ServiceUsuario.getInstancia().findAllByUsuario(usuario).get(0);
                enlace.setUsuario(user);
            }

            String preview = ServiceLink.getInstancia().getPreview(url);
            String acortado = ServiceLink.getInstancia().getAcortado();

            enlace.setFotoBase64(preview);
            enlace.setURL(url);
            enlace.setURLF(acortado);

            enlace = ServiceLink.getInstancia().create(enlace);
            System.out.println(enlace.getId());
            return enlace;

        }
        return null;
    }

}
