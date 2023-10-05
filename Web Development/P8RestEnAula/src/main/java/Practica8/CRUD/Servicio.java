package Practica8.CRUD;

import Practica8.encapsulaciones.Estudiante;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.List;

public class Servicio {

    public static void listar(String url)
    {
        HttpResponse<JsonNode> response = Unirest.get(url)
                .header("accept", "application/json")
                .queryString("apiKey", "123")
                .asJson();
        System.out.println("Respuesta: "+response.getStatus());
        JSONArray array = response.getBody().getArray();
        int cantidad = array.length();
        System.out.println("Respuesta: "+cantidad);
        for (int i = 0; i < cantidad; i++) {
            JSONObject object = array.getJSONObject(i);
            System.out.println("Matrícula: "+object.getInt("matricula"));
            System.out.println("Nombre: "+object.getString("nombre"));
            System.out.println("Carrera: "+object.getString("carrera"));
        }
    }

    public static void buscar(int matricula, String url)
    {
        HttpResponse response = Unirest.get(url+matricula)
                .queryString("apiKey", "123")
                .asJson();

        System.out.println("Respuesta: "+response.getStatus());
        JSONObject object = new JSONObject(response.getBody().toString());
        System.out.println("Matrícula: "+object.getInt("matricula"));
        System.out.println("Nombre: "+object.getString("nombre"));
        System.out.println("Carrera: "+object.getString("carrera"));


        //System.out.println("matricula="+estudiante.getMatricula()+", Nombre="+estudiante.getNombre()+", carrera="+estudiante.getCarrera());
    }

    public static void crear(int matricula, String nombre, String carrera, String url)
    {
        HttpResponse<JsonNode> estudiante = Unirest.post(url)
                .header("Content-Type", "application/json")
                .queryString("apiKey", "123")
                .body(new Estudiante(matricula,nombre,carrera))
                .asJson();
        System.out.println("Respuesta: "+estudiante.getStatus());
        System.out.println("Mensaje: "+estudiante.getBody().toString());
    }

    public static void borrar(int matricula, String url)
    {
        HttpResponse estudiante = Unirest.delete(url+matricula).asEmpty();
        System.out.println("Respuesta: "+estudiante.getStatus());
    }
}
