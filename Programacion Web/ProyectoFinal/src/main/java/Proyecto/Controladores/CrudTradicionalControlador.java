package Proyecto.Controladores;

import Proyecto.Entidades.Link;
import Proyecto.Entidades.Usuario;
import Proyecto.Entidades.Visitante;
import Proyecto.Services.ServiceLink;
import Proyecto.Services.ServiceUsuario;
import Proyecto.Services.ServiceVisitante;
import io.javalin.Javalin;

import java.net.InetAddress;
import java.util.*;


/**
 * Representa las rutas para manejar las operaciones de petición - respuesta.
 */
public class CrudTradicionalControlador{

    private Javalin app;
    private static String modoConexion = "";
    private ServiceVisitante serviceVisitante = Proyecto.Services.ServiceVisitante.getInstancia();
    private ServiceUsuario serviceUsuario = ServiceUsuario.getInstancia();
    private ServiceLink serviceLink = ServiceLink.getInstancia();
    private Boolean checkLogin= false;
    private Boolean checkRegister= false;


    public CrudTradicionalControlador(Javalin app) {
        this.app = app;
    }

    /**
     * Las clases que implementan el sistema de plantilla están agregadas en PlantillasControlador.
     * http://localhost:7000/crud-simple/listar
     */
    public void aplicarRutas(){
        generarAdmin();

        /*Si el carrito no existe dentro de la sesion entonces se crea y se agrega como un atributo*/
        app.before(ctx -> {
            if(ctx.sessionAttribute("Enlaces") == null) {
                Set<Link> enlaces = new HashSet<>();
                ctx.sessionAttribute("Enlaces", enlaces);
            }
        });
        /*Ruta raiz
         * Muesta los productos disponibles para agragar al carrito*/
        app.get("/", ctx -> {
            Map<String, Object> aux =  new HashMap<>();
            Set<Link> enlaces;

            Usuario usuario = ctx.sessionAttribute("usuario");
            if(usuario != null){
                enlaces = usuario.getEnlaces();
            }else{
                enlaces = ctx.sessionAttribute("Enlaces");
            }

            aux.put("usuario",usuario);
            aux.put("Enlaces",enlaces);
            System.out.println(usuario);
            ctx.render("/publico/index.html",aux);
        });

        /*Peticion que agrega un producto al carrito del usuario
         * Si el producto ya está en el carrito entonces se aumenta la cantidad que se quiere*/
        app.post("/acortador", ctx -> {
            String URL = ctx.formParam("link");

            Usuario usuario = ctx.sessionAttribute("usuario");
            Link aux = new Link();
            aux.setURL(URL);
            aux.setURLF(serviceLink.getAcortado());
            aux.setFotoBase64(serviceLink.getPreview(URL));

            Set<Link> listaActual;
            if(usuario!=null)
            {
                aux.setUsuario(usuario);
                listaActual = usuario.getEnlaces();
                listaActual.add(aux);
                usuario.setEnlaces(listaActual);
                serviceLink.create(aux);
                serviceUsuario.edit(usuario);
            }else{
                listaActual= ctx.sessionAttribute("Enlaces");
                listaActual.add(aux);
                serviceLink.create(aux);
                ctx.sessionAttribute("Enlaces", listaActual);
            }
            ctx.redirect("/");
        });

        app.get("/re/{direct}", ctx -> {
            int id = ctx.pathParamAsClass("direct",Integer.class).get();
            Link aux = serviceLink.find(id);
            String detalles = getSistemaO(ctx.userAgent().toLowerCase());
            String nav = getNavegador(ctx.header("user-agent").toLowerCase());
            Visitante visita = new Visitante();
            InetAddress ip = InetAddress.getLocalHost();
            visita.setIpaddress(ip.getHostAddress());
            visita.setSistema(detalles);
            visita.setNavegador(nav);

            aux.setVisitas(aux.getVisitas()+1);
            serviceVisitante.create(visita);

            List<Visitante> visitass = aux.getVisitantes();
            visitass.add(visita);
            aux.setVisitantes(visitass);
            serviceLink.edit(aux);

            ctx.redirect(aux.getURL());
        });

        app.get("/ver/{id}",ctx -> {
            int id = ctx.pathParamAsClass("id",Integer.class).get();
            Link enlace = serviceLink.find(id);

            Map<String,Object> map = new HashMap<>();
            map.put("usuario",ctx.sessionAttribute("usuario"));
            map.put("enlace",enlace);
            map.put("map",enlace.calculadora());
            if(enlace.calculadora() != null) {
                map.put("llaves", enlace.calculadora().keySet());
                map.put("valores", enlace.calculadora().values());
            }

            //System.out.println(enlace.calculadora().size());
            //map.put("tamanio",enlace.calculadora().entrySet().size());

            ctx.render("/publico/enlace.html",map);
        });

        app.get("/autenti",ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            if(checkLogin)
            {
                checkLogin=false;
                modelo.put("check", true);
            }else{
                modelo.put("check", checkLogin);
            }
            ctx.render("/publico/login.html",modelo);
        });

        app.post("/autenticar", ctx -> {
            String user = ctx.formParam("usuario");
            String password = ctx.formParam("password");

            Usuario usuario = serviceUsuario.autentificacion(user.toLowerCase(), password.toLowerCase());

            if( usuario != null ){
                checkLogin=false;
                ctx.sessionAttribute("usuario", usuario);
                ctx.redirect("/");
            }else{
                checkLogin=true;
                ctx.redirect("/autenti");
            }

        });

        app.get("/registrar", ctx -> {
            Map<String, Object> modelo = new HashMap<>();

            if(checkRegister)
            {
                checkRegister=false;
                modelo.put("check", true);
            }else{
                modelo.put("check", checkRegister);
            }
            ctx.render("/publico/login.html",modelo);
        });

        app.post("/registrar/user", ctx -> {
            String usuario = ctx.formParam("email");
            String nombre = ctx.formParam("name");
            String password = ctx.formParam("pswd2");
            Usuario.RoleasAPP rol = Usuario.RoleasAPP.USUARIO;

            Usuario temp = new Usuario();
            temp.setUsuario(usuario.toLowerCase());
            temp.setNombre(nombre.toLowerCase());
            temp.setContrasenia(password.toLowerCase());
            temp.setRol(rol);

            if(serviceUsuario.findAllByUsuario(usuario.toLowerCase()).size() == 0)
            {
                serviceUsuario.create(temp);
                ctx.sessionAttribute("email",temp);
                ctx.redirect("/autenti");
                checkRegister= false;
            }else{
                checkRegister = true;
                ctx.redirect("/registrar");
            }
        });

        app.post("/ascender/{idUsuario}", ctx -> {
            //obtengo el usuario
            Usuario temp = serviceUsuario.find(ctx.pathParamAsClass("idUsuario", Integer.class).get());
            temp.setRol(Usuario.RoleasAPP.ADMIN);
            serviceUsuario.edit(temp);
            ctx.redirect("/usuarios");
        });


        app.post("/descender/{idUsuario}", ctx -> {
            //obtengo el usuario
            Usuario temp = serviceUsuario.find(ctx.pathParamAsClass("idUsuario", Integer.class).get());
            temp.setRol(Usuario.RoleasAPP.USUARIO);
            serviceUsuario.edit(temp);
            ctx.redirect("/usuarios");
        });

        app.post("/eliminar/{idUsuario}", ctx -> {
            //obtengo el usuario
            int id =ctx.pathParamAsClass("idUsuario", Integer.class).get();
            serviceUsuario.delete(id);
            ctx.redirect("/usuarios");
        });

        app.get("/logout", ctx -> {
            //invalidando la sesion.
            ctx.sessionAttribute("usuario", null);
            ctx.redirect("/");
        });

        app.get("/usuarios", ctx -> {
            Usuario aux = ctx.sessionAttribute("usuario");
            List<Usuario> lista = serviceUsuario.getUsuarios();

            Map<String, Object> modelo = new HashMap<>();
            modelo.put("usuario", aux);
            modelo.put("usuarios",lista);
            ctx.render("/publico/users.html",modelo);
        });

        app.get("/enlaces", ctx -> {
            Usuario usuario = ctx.sessionAttribute("usuario");
            List<Link> lista = serviceLink.findAll();

            Map<String, Object> modelo = new HashMap<>();
            modelo.put("links", lista);
            modelo.put("usuario",usuario);
            ctx.render("/publico/enlaces.html",modelo);
        });

        app.get("/eliminar/enlace/{id}", ctx -> {
            int id =ctx.pathParamAsClass("id", Integer.class).get();
            Boolean estado = serviceLink.delete(id);

            if(estado)
            {
                Set<Link> Enlaces = ctx.sessionAttribute("Enlaces");
                Set<Link> nuevoEnlace = serviceLink.deleteByID(id, Enlaces);

                if(nuevoEnlace != null)
                {
                    ctx.sessionAttribute("Enlaces",nuevoEnlace);
                }
            }

            ctx.redirect("/enlaces");
        });

        app.exception(Exception.class, (exception, ctx) -> {
        ctx.status(500);
        ctx.redirect("/publico/recuperar.html");
        exception.printStackTrace();
    });



    }
/*
    private static List<String> getPaginas() {
        int pag = ServiceProducto.getInstance().pag();
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= pag; i++){
            String aux = String.valueOf(i);
            list.add(aux);
        }

        return list;
    }
    */

    private String getSistemaO(String user){
        String detalles = "";
        if(user.indexOf("windows") >= 0){
            detalles = "Windows";
        }else if(user.indexOf("mac") >= 0){
            detalles = "MacOs";
        }else if(user.indexOf("x11") >= 0){
            detalles = "Unix";
        }else if(user.indexOf("android") >= 0){
            detalles = "Android";
        }else if(user.indexOf("iphone") >= 0){
            detalles = "IOS";
        }
        return detalles;

    }
    private String getNavegador(String user){
        String detalles = "";

        if(user.contains("edge")  ){
            detalles = "Edge";
        }else if(user.contains("safari")){
            detalles = "Safari";
        }else if(user.contains("opera") ){
            detalles = "Opera";
        }else if(user.contains("chrome")){
            detalles = "Chrome";
        }else if(user.contains("firefox")){
            detalles = "Firefox";
        }else if(user.contains("brave")){
            detalles = "Brave";
        }
        return detalles;
    }

    private static void generarAdmin() {

        if(ServiceUsuario.getInstancia().autentificacion("admin","admin") == null)
        {
            Usuario user = new Usuario();
            user.setUsuario("admin");
            user.setNombre("admin");
            user.setRol(Usuario.RoleasAPP.ADMIN);
            user.setContrasenia("admin");
            ServiceUsuario.getInstancia().create(user);
        }
    }

}
