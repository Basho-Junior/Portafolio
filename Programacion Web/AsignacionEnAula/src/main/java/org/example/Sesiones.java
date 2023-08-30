package org.example;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;


public class Sesiones extends Base {
    public Sesiones(Javalin app) {
        super(app);
    }

    public static List<String> lista = new ArrayList<>();
    @Override
    public void aplicarRutas() {

         app.post("/login-cookies", ctx -> {
            //recibiendo información del formulario.
            String usuario = ctx.formParam("usuario");
            String contrasena = ctx.formParam("contrasena");
            if(usuario==null || contrasena == null){
                //errror para procesar la información.
                ctx.redirect("/login.html");
                return;
            }
            //Estamos haciendo fake de un servicio de autenticacion, busque en un servicio.
            ctx.cookie("usuario", usuario, 120);
            ctx.cookie("nombre", usuario, 120);
            //enviando a la vista.
            ctx.redirect("/inicio-cookie");
        });

        /**
         *
         *
         */
        app.get("/inicio-cookie", ctx -> {
            if(ctx.cookie("nombre") == null || ctx.cookie("usuario")== null){//no ha realizado el proceso de login.
                ctx.redirect("/login.html");
                return;
            }
            //ctx.result("Hola "+ctx.cookie("nombre")+", gracias por su visita!");
            ctx.redirect("index.html?"+ctx.cookie("nombre"));
        });

        /**
         * Ejemplo de como autenticar utilizando sesiones.
         */
        app.post("/autenticar", ctx -> {
            //Obteniendo la informacion de la petion. Pendiente validar los parametros.
            String nombreUsuario = ctx.formParam("usuario");
            String password = ctx.formParam("password");
            //Autenticando el usuario para nuestro ejemplo siempre da una respuesta correcta.
            Usuario usuario = FakeServices.getInstancia().autheticarUsuario(nombreUsuario, password);
            //agregando el usuario en la session... se puede validar si existe para solicitar el cambio.-
            ctx.sessionAttribute("usuario", usuario);
            //redireccionando la vista con autorizacion.
            ctx.redirect("/zona-admin-clasica/");
        });

        app.get("/contexto", ctx -> {
            ctx.req.setAttribute("variable-request", "valor"); //se mantiene hasta la respuesta del servidor.
            ctx.sessionAttribute("variable-sesion", "....."); //asociado a la cookie sesion que crea el servidor. 30 min.
            //aplicación del referencia del objeto de clase o de instancia que tenga acceso.
            lista.add("asasd");

        });

    }
}
