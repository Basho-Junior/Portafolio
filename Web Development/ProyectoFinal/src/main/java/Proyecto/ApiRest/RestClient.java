package Proyecto.ApiRest;

import Proyecto.Entidades.LoginSesion;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url;
        String usuario;
        String contrasenia;
        int num =1;
        do{
            System.out.println("MENU:\n1.ENLACES DE CLIENTE\n2.REGISTRAR URL\n->");
            num = sc.nextInt();

            System.out.println("USUARIO-> ");
            sc.nextLine();
            usuario = sc.nextLine();
            System.out.println("CONTRASENIA-> ");

            contrasenia = sc.nextLine();
            switch(num)
            {
                case 1 :
                    listarEnlace(usuario,contrasenia);
                    break;

                case 2 :
                    System.out.println("URL-> ");
                    url = sc.nextLine();
                    registrarURL(url,usuario,contrasenia);
                    break; // break es opcional

                default :
                    System.out.println("NO EXISTE OPCION");
            }

        }while(num != 0);



    }

    public static void registrarURL(String url,String usuario, String contrasenia)
    {

        System.out.println("url"+url);
        System.out.println(usuario);
        System.out.println(contrasenia);
        LoginSesion jsonResponse = Unirest.post("http://localhost:7000/login/RestApi")
                .queryString("usuario", usuario)
                .queryString("contrasenia", contrasenia)
                .asObject( LoginSesion.class)
                .getBody();

        if(jsonResponse != null)
        {
            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("Authorization", "Bearer "+jsonResponse.getToken());

            HttpResponse<JsonNode> urlCreada
                    = Unirest.post("http://localhost:7000/RestApi/registrarURL")
                    .queryString("usuario", usuario)
                    .queryString("url", url)
                    .headers(headers)
                    .asJson();

            System.out.println("Datos sobre la Url creada:\n"+urlCreada.getBody().toString());
        }else{
            System.out.println(401+", INCORRECTA LA AUTENTIFICACION");
        }
    }

    public static void listarEnlace(String usuario, String contrasenia)
    {

        LoginSesion jsonResponse = Unirest.post("http://localhost:7000/login/RestApi")
                .queryString("usuario", usuario)
                .queryString("contrasenia", contrasenia)
                .asObject(LoginSesion.class)
                .getBody();

        if(jsonResponse != null)
        {
            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("Authorization", "Bearer "+jsonResponse.getToken());

            HttpResponse<JsonNode> listaEnlaceGet
                    = Unirest.get("http://localhost:7000/RestApi/ListarUrl/"+usuario)
                    .headers(headers)
                    .asJson();

            System.out.println("ENLACES->\n"+listaEnlaceGet.getBody().toString());
        }else{
            System.out.println(401+", INCORRECTA LA AUTENTIFICACION");
        }
    }
}
