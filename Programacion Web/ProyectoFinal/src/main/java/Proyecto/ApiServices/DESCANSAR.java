package Proyecto.ApiServices;

import Proyecto.Controladores.REST;
import Proyecto.Entidades.LoginSesion;
import Proyecto.Entidades.Usuario;
import Proyecto.Services.ServiceLink;
import Proyecto.Services.ServiceUsuario;
import io.javalin.Javalin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;


import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Set;

import static io.javalin.apibuilder.ApiBuilder.*;

public class DESCANSAR {
    public final static String LLAVE_SECRETA = "asd12D1234dfr123@#4Fsdcasdd5g78a";
    public final static String ACCEPT_TYPE_JSON = "application/json";
    public final static String ACCEPT_TYPE_XML = "application/xml";
    public final static int BAD_REQUEST = 400;
    public final static int UNAUTHORIZED = 401;
    public final static int FORBIDDEN = 403;
    public final static int ERROR_INTERNO = 500;


    private Javalin app;

    private ServiceLink enlaceService = ServiceLink.getInstancia();
    private REST restControlador = REST.getInstance();


    public DESCANSAR(Javalin app) {
        this.app = app;
    }

    public void aplicarRutas() {
        app.routes(() -> {

            app.options("/*", ctx -> {
                System.out.println("Entrando al metodo de options");
                String accessControlRequestHeaders = ctx.header("Access-Control-Request-Headers");
                if (accessControlRequestHeaders != null) {
                    ctx.header("Access-Control-Allow-Headers",accessControlRequestHeaders);
                }

                String accessControlRequestMethod = ctx.header("Access-Control-Request-Method");
                if (accessControlRequestMethod != null) {
                    ctx.header("Access-Control-Allow-Methods",accessControlRequestMethod);
                }

            });

            before(ctx -> {
                System.out.println("Aplicando header del API del CORS");
                ctx.header("Access-Control-Allow-Origin", "*");
            });

            app.post("/login/RestApi", ctx -> {

                String usuario = ctx.queryParam("usuario");
                String password = ctx.queryParam("contrasenia");

                System.out.println(usuario);
                System.out.println(password);
                Usuario usuarioObj = ServiceUsuario.getInstancia().autentificacion(usuario,password);
                if(usuarioObj == null)
                {
                    System.out.println("Autentificacion no Correcta");
                    ctx.status(UNAUTHORIZED).result("Autentificacion no Correcta");
                }else{
                    System.out.println(usuarioObj.getUsuario());
                    ctx.json(generacionJsonWebToken(usuarioObj));
                }

            });

            path("/RestApi", () -> {
                /**
                 * Ejemplo de una API REST, implementando el CRUD
                 * ir a
                 */

                before(ctx ->{
                    System.out.println("Analizando que exista el token");


                    if(ctx.req.getMethod() == "OPTIONS"){
                        return;
                    }


                    String header = "Authorization";
                    String prefijo = "Bearer";

                    Set<String> listaHeader = ctx.headerMap().keySet();
                    for(String key : listaHeader){
                        System.out.println(String.format("header[%s] = %s", key, ctx.header(key)));
                    }

                    String headerAutentificacion = ctx.header(header);
                    if(headerAutentificacion ==null || !headerAutentificacion.startsWith(prefijo)){
                        System.out.println("No tiene permiso para acceder al recurso, no enviando header de autorizacion");
                    }

                    String tramaJwt = headerAutentificacion.replace(prefijo, "");
                    try {
                        Claims claims = Jwts.parser()
                                .setSigningKey(Keys.hmacShaKeyFor(LLAVE_SECRETA.getBytes()))
                                .parseClaimsJws(tramaJwt).getBody();
                        System.out.println("Mostrando el JWT recibido: " + claims.toString());
                    }catch (ExpiredJwtException | MalformedJwtException | SignatureException e){
                        System.out.println(e.getMessage());
                    }

                });

                after(ctx -> {
                    ctx.header("Content-Type", "application/json");
                });

                get("/ListarUrl/{usuario}", ctx -> {
                    ctx.json(REST.getInstance().createArray(ctx.pathParamAsClass("usuario",String.class).get()));
                });

                post("/registrarURL", ctx -> {
                    String usuario = ctx.queryParam("usuario");
                    String url = ctx.queryParam("url");
                    ctx.json(REST.getInstance().createLink(url,usuario));
                });
            });

        });


        app.exception(noExisteToken.class, (exception, ctx) -> {
            ctx.status(FORBIDDEN);
            ctx.json(""+exception.getLocalizedMessage());
        });

        app.exception(noExisteUser.class, (exception, ctx) -> {
            ctx.status(404);
            ctx.json(""+exception.getLocalizedMessage());
        });


    }

    private static LoginSesion generacionJsonWebToken(Usuario usuario){
        LoginSesion loginResponse = new LoginSesion();
        //generando la llave.
        SecretKey secretKey = Keys.hmacShaKeyFor(LLAVE_SECRETA.getBytes());
        //Generando la fecha valida
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(3);
        System.out.println("La fecha actual: "+localDateTime.toString());

        //
        Date fechaExpiracion = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-4)));
        String jwt = Jwts.builder()
                .setIssuer("Programacion-Web")
                .setSubject("Proyecto-Final")
                .setExpiration(fechaExpiracion)
                .claim("usuario", usuario.getUsuario())
                .claim("rol", usuario.getRol())
                .signWith(secretKey)
                .compact();
        loginResponse.setToken(jwt);
        loginResponse.setExpires_in(fechaExpiracion.getTime());
        return loginResponse;
    }

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
}
