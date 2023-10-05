package Parcial2.controladores;

import Parcial2.encapsulaciones.Estudiante;
import Parcial2.encapsulaciones.FormApp;
import Parcial2.encapsulaciones.Historial;
import Parcial2.encapsulaciones.Usuario;
import Parcial2.servicios.ServiceEstudiante;
import Parcial2.servicios.ServiceHistorial;
import Parcial2.servicios.ServiceUsuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.eclipse.jetty.websocket.api.Session;
import org.jasypt.util.text.AES256TextEncryptor;

import java.io.IOException;
import java.util.*;

public class ConceptoBasicosControlador {

    private Javalin app;

    public ConceptoBasicosControlador(Javalin app){
        this.app = app;
    }

    public static List<Session> Conectados = new ArrayList<>();

    public void aplicarRutas(){
        /**
         * Manejador que se aplica todas las llamadas que sean realizada.
         * Notar la ausencia del path.
         */
        app.before(ctx -> {
            //
            String mensaje = String.format("Manejador before aplicando a todas las llamadas: %s, Contexto: %s, Metodo: %s",
                    ctx.req.getRemoteHost(),
                    ctx.path(),
                    ctx.req.getMethod());
            //
            System.out.println(mensaje);
        });

        app.get("/", ctx -> {
            ctx.redirect("/html5/index.html");
        });

        /*Hace render al log-in
         * direc determina a que vista será rediccionado luego de autentificarse correctamente*/
        app.get("/autenti/", ctx -> {
            String direc = ctx.pathParam("direc");
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("direc",direc);
            ctx.render("/html5/login.html",modelo);
        });

        /*Post de autentificacion
         * redirige a la ventana especificada en el get*/
        app.post("/autenti/",ctx -> {
            String usuario = ctx.formParam("usuario");
            String pass = ctx.formParam("password");
            String passw = ctx.formParam("password");
            //String temp = ctx.pathParam("direc");
            String recordar = ctx.formParam("recordar");

            if(usuario == null || pass == null){
                ctx.redirect("/html5/login.html");
            }
            AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
            textEncryptor.setPassword("myEncryptionPassword");
            pass = textEncryptor.encrypt(pass);
            if(recordar != null){
                ctx.cookie("usuario", usuario,(3600*24*7));//Una semana en segundos
                ctx.cookie("mist", pass,(3600*24*7));
            }
            //Encriptar cookie
            ctx.cookie("usuario", usuario);
            ctx.cookie("mist", pass);
            //ServiceUsuario.getInstancia().create(user);
                for (int i = 0; i < ServiceUsuario.getInstancia().getUsuario().size(); i++){
                    if(ServiceUsuario.getInstancia().getUsuario().get(i).getUsuario().equals(usuario) && ServiceUsuario.getInstancia().getUsuario().get(i).getPassword().equals(passw)){
                        ctx.redirect("/html5/listado.html");
                    }else {
                        ctx.redirect("/html5/login.html");
                    }
                }

        });

        app.get("/registrar/", ctx -> {
            String direc = ctx.pathParam("direc");
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("direc",direc);
            ctx.render("/html5/login.html",modelo);
        });

        /*Post de autentificacion
         * redirige a la ventana especificada en el get*/
        app.post("/registrar/",ctx -> {
            String usuario = ctx.formParam("user");
            String email = ctx.formParam("email");
            String pass = ctx.formParam("pswd1");
            String cpass = ctx.formParam("pswd2");
            //String temp = ctx.pathParam("direc");

            if(!(cpass.equals(pass))){
                ctx.redirect("/html5/login.html");
            } else {
                System.out.println("si");
                //ctx.html("<h2>  alert('Hello world!');  </h2> ");
                Usuario user = new Usuario(email,usuario,pass);
                AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
                textEncryptor.setPassword("myEncryptionPassword");
                pass = textEncryptor.encrypt(pass);
                //Encriptar cookie
                ctx.cookie("usuario", usuario);
                ctx.cookie("mist", pass);
                ServiceUsuario.getInstancia().create(user);
                ctx.redirect("/html5/login.html");
            }

        });

        app.get("/ingresar/", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("accion","/ingresar");
            Estudiante temp = new Estudiante();
            List<Estudiante> temps = ServiceEstudiante.getInstance().getEstudiante();
            modelo.put("estudiantes",temps);
            modelo.put("estudiant",temp);
            ctx.render("/publico/html5/listado.html",modelo);
        });

        /*Registra un producto en el sistema a partir de los valores del formulario*/
        app.post("/ingresar/", ctx -> {
            int matricula = ctx.formParamAsClass("matricula",Integer.class).get();
            String nombre = ctx.formParam("nombre");
            String sector = ctx.formParam("sector");
            String nivel = ctx.formParam("nivel");
            float latitud = ctx.formParamAsClass("latitud",Float.class).get();
            float longitud =ctx.formParamAsClass("longitud",Float.class).get();
            //Usuario user = new Usuario();
            Estudiante temp = new Estudiante(matricula,nombre,sector,nivel);
            ServiceEstudiante.getInstance().create(temp);
            Historial hist = new Historial(temp.getId(),ctx.cookie("usuario"),latitud,longitud);
            ServiceHistorial.getInstance().create(hist);
            Map<String, Object> modelo = new HashMap<>();
            List<Estudiante> temps = ServiceEstudiante.getInstance().getEstudiante();
            modelo.put("estudiantes",temps);
            modelo.put("estudiant",temp);
            ctx.render("/publico/html5/listado.html",modelo);
        });

        app.get("/remover/{id}", ctx -> {
            ServiceEstudiante.getInstance().eliminarEstudiante(ctx.pathParamAsClass("id",Integer.class).get());
            Map<String, Object> modelo = new HashMap<>();
            List<Estudiante> temps = ServiceEstudiante.getInstance().getEstudiante();
            modelo.put("estudiantes",temps);
            Estudiante temp = new Estudiante();
            modelo.put("estudiant",temp);
            ctx.render("/publico/html5/listado.html",modelo);
        });

        /*Permite editar un producto ya agregado
         * Se envia un string para determinar que se realizará una modificación luego del post*/
        app.get("/editar/{id}", ctx -> {
            Estudiante temp = ServiceEstudiante.getInstance().buscarEstudiante(ctx.pathParamAsClass("id", Integer.class).get());
            Map<String, Object> modelo = new HashMap<>();
            List<Estudiante> temps = ServiceEstudiante.getInstance().getEstudiante();
            modelo.put("estudiantes",temps);
            modelo.put("estudiant",temp);
            modelo.put("accion","/editar/"+ctx.pathParamAsClass("id", Integer.class).get());

            ctx.render("/publico/html5/listado.html",modelo);

        });


        /*Post luego del formulario de modificar producto
         * Actualiza los valores a partir de lo enviado en el formulario*/
        app.post("/editar/{id}", ctx -> {
            int matricula = ctx.formParamAsClass("matriculas",Integer.class).get();
            String nombre = ctx.formParam("nombres");
            String sector = ctx.formParam("sectors");
            String nivel = ctx.formParam("nivels");

            Estudiante temp = new Estudiante(matricula,nombre,sector,nivel);
            temp.setId(ctx.pathParamAsClass("id",Integer.class).get());
            ServiceEstudiante.getInstance().edit(temp);
            List<Estudiante> temps = ServiceEstudiante.getInstance().getEstudiante();
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("estudiantes",temps);
            modelo.put("estudiant",temp);
            ctx.render("/publico/html5/listado.html",modelo);
        });

        app.get("/estudiantes", ctx -> {
            Estudiante temp = new Estudiante();
            Map<String, Object> modelo = new HashMap<>();
            List<Estudiante> temps = ServiceEstudiante.getInstance().getEstudiante();
            modelo.put("estudiantes",temps);
            modelo.put("estudiant",temp);

            ctx.render("/publico/html5/listado.html",modelo);

        });

        app.get("/mapa/{id}", ctx -> {
            Estudiante temp = ServiceEstudiante.getInstance().buscarEstudiante(ctx.pathParamAsClass("id", Integer.class).get());
            Historial temp2 = ServiceHistorial.getInstance().buscarHistorial(temp.getId());
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("historial",temp2);
            modelo.put("accion","/mapa/"+ctx.pathParamAsClass("id", Integer.class).get());

            ctx.render("/publico/html5/mapa.html",modelo);

        });

        app.get("/logout", ctx -> {
            //invalidando la sesion.
            if(ctx.cookie("usuario")!= null && ctx.cookie("mist")!= null){
                ctx.removeCookie("usuario");
                ctx.removeCookie("mist");
            }
            ctx.redirect("/html5/login.html");
        });


        /**
         * Manejador que se aplica de la ruta /isc415
         */
        app.before("/isc415", ctx -> {
            //
            String mensaje = String.format("Manejador before aplicando en el Contexto: %s, Metodo: %s",
                    ctx.req.getRequestURI(),
                    ctx.req.getMethod());
            //aplicando cambios o validaciones.
            ctx.attribute("mi-variable", "Hola Mundo"); //variable en el contexto de petición
            //
            System.out.println(mensaje);
        });

        /**
         * Handler sobre el endpoint, en al variable ctx.
         */
        app.get("/isc415", ctx -> {
            String metodo = ctx.req.getMethod(); //la información del encapsulada del cliente.
            metodo = ctx.method();
            ctx.res.setHeader("asignatura", "ISC-415");
            ctx.header("otro-header", "Mi header enviado");
            //La forma utilizando HttpServletResponse
            /*PrintWriter printWriter = new PrintWriter(ctx.res.getOutputStream());
            printWriter.println("Endpoint "+ctx.req.getRequestURI()+" -  Metodo: "+metodo);
            printWriter.flush();
            printWriter.close();*/
            ctx.result("Endpoint "+ctx.req.getRequestURI()+" -  Metodo: "+metodo+" - Variable: "+ctx.attribute("mi-variable"));
        });

        /**
         * Handler despues de cualquier llamada, siempre que no exista un error.
         * nota la ausencia de path
         */
        app.after(ctx -> {
            String mensaje = String.format("Handler after para cualquier llamada - Usuario: %s, Contexto: %s",
                    ctx.req.getRemoteHost(),
                    ctx.contextPath()
                    );
            System.out.println(mensaje);
        });

        /**
         * Aplica luego de la respuesta del endpoint del contexto /isc415
         */
        app.after("/isc415", ctx -> {
            //
            String mensaje = String.format("Manejador after aplicando en el Contexto: %s, Metodo: %s",
                    ctx.req.getRequestURI(),
                    ctx.req.getMethod());
            //aplicando cambios o validaciones.
            ctx.header("incluido-after","fue ejecutando en bloque after");
            //ctx.header("nombre"); ctx.req.getHeader("nombre") desde el cliente.
            //ctx.header("otro-header", ctx.res.getHeader("otro-header").toUpperCase()+" - Incluir otra cosa....");
            //
            System.out.println(mensaje);
        });

        app.ws("/conexion", ws -> {
            ws.onConnect(ctx -> {
                System.out.println("Conexion Iniciada - "+ctx.getSessionId());
                Conectados.add(ctx.session);

            });
            ws.onMessage(ctx -> {
                ObjectMapper objectMapper = new ObjectMapper();
                System.out.println("Recibiendo Mensaje...");
                List<FormApp> forma = objectMapper.readValue(ctx.message(), new TypeReference<List<FormApp>>() {});
                System.out.println("Form Recieved " +  agregarformaBD(forma));
                System.out.println("Destinatario "+ctx.getSessionId());
                System.out.println("Mensaje: "+ctx.message());

            });
            ws.onClose(ctx -> {
                System.out.println("Conexión terminada... "+ctx.getSessionId());
                Conectados.remove(ctx.session);
            });
            ws.onError(ctx -> {
                System.out.println("Ocurrió un error");
            });
            ws.onBinaryMessage(ctx -> {
                System.out.println("Mensaje Binario "+ctx.getSessionId());
            });

        });


        /**
         * la ruta (path) puede ser la misma siempre y cuando el verbo cambie.
         * Ver los diferentes ejemplos.
         */
        app.post("/isc415",this::procesamiento);

        app.put("/isc415", this::procesamiento);

        app.delete("/isc415", this::procesamiento);

        app.options("/isc415", this::procesamiento);

        app.patch("/isc415", this::procesamiento);

        app.head("/isc415", this::procesamiento);

        /**
         * bloque retornar el mimetype del archivo para el cache.
         */
        app.after("/html5/sinconexion.appcache", ctx -> {
            System.out.println("Llamando el cache....");
            ctx.contentType("text/cache-manifest");
        });

    }

    /**
     *
     * @param ctx
     */
    private void procesamiento(Context ctx){
        ctx.result("Trabajando por el metodo: "+ctx.method()+" - Header[profesor] = "+ctx.header("profesor"));
    }

    private int agregarformaBD(List<FormApp> form) {
        Estudiante aux = null;
        Historial temp = null;
        for (FormApp res: form) {
            temp = new Historial(res.getId(),res.getUsuario(),res.getLatitud(),res.getLongitud());
            aux = new Estudiante(res.getMatricula(),res.getNombre(),res.getSector(),res.getNivel());
            ServiceEstudiante.getInstance().create(aux);
            ServiceHistorial.getInstance().create(temp);
        }
        return  form.size();

    }
}
