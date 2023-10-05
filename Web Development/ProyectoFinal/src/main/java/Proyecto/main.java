package Proyecto;

import Proyecto.ApiServices.DESCANSAR;
import Proyecto.Controladores.CrudTradicionalControlador;
import Proyecto.Controladores.REST;
import Proyecto.Controladores.SOAP;
import Proyecto.Entidades.Link;
import Proyecto.Entidades.Usuario;
import Proyecto.Services.BootStrapServices;
import Proyecto.Services.ServiceUsuario;
import Proyecto.Servidor.Server;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class main {
    private static String modoConexion = "";
    public static void main(String[] args) {
        //Ejemplo hola mundo
        String mensaje = "Hola Mundo en Javalin :-D";
        System.out.println(mensaje);

        if(args.length >= 1){
            modoConexion = args[0];
            System.out.println("Modo de Operacion: "+modoConexion);
        }
        if(modoConexion.isEmpty()) {
            BootStrapServices.getInstancia().init();

        }

        //Creando la instancia del servidor.
        Javalin app = Javalin.create(config ->{
            config.addStaticFiles(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/publico";
                staticFileConfig.location = Location.CLASSPATH;
            });
            config.registerPlugin(new RouteOverviewPlugin("/rutas")); //aplicando plugins de las rutas
            config.enableCorsForAllOrigins();
            config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));

        });

        //

        //creando el manejador
        //app.get("/", ctx -> ctx.redirect("/listadoProductos.html"));

        new SOAP(app).aplicarRutas();
        new DESCANSAR(app).aplicarRutas();
        new CrudTradicionalControlador(app).aplicarRutas();

        app.start(getHerokuAssignedPort());

        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            server.blockunitlShutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Endpoint ejemplos html5.
        app.get("/fecha", ctx -> {
            ctx.result(""+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        });

        //Filtro para enviar el header de validación
        app.after(ctx -> {
            //System.out.println("Enviando el header de seguridad para el Service Worker");
            ctx.header("Service-Worker-Allowed", "/");
        });

    }

    /**
     * Metodo para indicar el puerto en Heroku
     * @return
     */
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 7000; //Retorna el puerto por defecto en caso de no estar en Heroku.
    }

    public static String getModoConexion(){
        return modoConexion;
    }

    private static OpenApiOptions getOpenApiOptions() {
        Info applicationInfo = new Info()
                .version("1.0")
                .description("My Application");
        return new OpenApiOptions(applicationInfo).path("/openapi").swagger(new SwaggerOptions("/openapi-ui"));
    }

    public static String codeGenerator() {
        int[] arr = {58, 59, 60, 61, 62, 63, 64};
        int leftLimit = 48; // letter 'a'
        int rightLimit = 90; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            if (!IntStream.of(arr).anyMatch(n -> n == randomLimitedInt)) {
                buffer.append((char) randomLimitedInt);
            } else {
                i--;
            }
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

}
