
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.staticfiles.Location;
import org.example.Sesiones;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import org.example.ZonaAdminClasica;


import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        //Ejemplo hola mundo
        String mensaje = "Hola Mundo en Javalin :-D";
        System.out.println(mensaje);

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
        app.start(getHerokuAssignedPort());

        //creando el manejador
        app.get("/", ctx -> ctx.redirect("/zona-admin-clasica/"));

        //ejemplos de cookies y sesiones.
        new Sesiones(app).aplicarRutas();
        new ZonaAdminClasica(app).aplicarRutas();


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

    private static OpenApiOptions getOpenApiOptions() {
        Info applicationInfo = new Info()
                .version("1.0")
                .description("My Application");
        return new OpenApiOptions(applicationInfo).path("/openapi").swagger(new SwaggerOptions("/openapi-ui"));
    }
}
