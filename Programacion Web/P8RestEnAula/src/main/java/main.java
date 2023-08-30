
import Practica8.CRUD.Servicio;
import com.google.gson.Gson;
import Practica8.encapsulaciones.Estudiante;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.apache.http.io.SessionOutputBuffer;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {


        System.out.println("Cliente");

        String url = "http://localhost:7000/api/estudiante/";
//Consulta del api para todos los estudiantes.
        /*HttpResponse<JsonNode> response = Unirest.get(url)
                .header("accept", "application/json")
                .queryString("apiKey", "123")
                .asJson();
        System.out.println("Estatus de la llamada: "+response.getStatus());
        JSONArray array = response.getBody().getArray();
        int cantidad = array.length();
        System.out.println("La cantida de elementos recuperados: "+cantidad);
        for (int i = 0; i < cantidad; i++) {
            JSONObject object = array.getJSONObject(i);
            System.out.println("Matrícula: "+object.getInt("matricula"));
            System.out.println("Nombre: "+object.getString("nombre"));
            System.out.println("Carrera: "+object.getString("carrera"));
        }

        List<Estudiante> estudiantes = Unirest.get(url)
                .asObject(new GenericType<List<Estudiante>>(){})
                .getBody();
        System.out.println("La cntidad de elementos: "+estudiantes.size());

        //Enviar estudiante al API
        Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(new Gson().toJson(new Estudiante(1, "Estudiante 1", "ISC")))
                .asEmpty();
        */
        System.out.println("--BIENVENIDO AL PROGRAMA DE PRUEBA CON REST--");
        int decision = 1;
        int matricula = 0;
        String nombre = null;
        String carrera = null;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("QUE DESE HACER?(INGRESAR NUMERO)");
            System.out.println("1 - LISTAR");
            System.out.println("2 - CONSULTAR");
            System.out.println("3 - CREAR");
            System.out.println("4 - BORRAR");
            System.out.print("->");
            decision = sc.nextInt();

            if(decision == 1){
                Servicio.listar(url);
            } else if (decision == 2) {
                System.out.println("MATRICULA DEL ESTUDIANTE:");
                System.out.print("->");
                matricula = sc.nextInt();
                Servicio.buscar(matricula,url);
            } else if (decision == 3) {
                System.out.println("MATRICULA:");
                System.out.print("->");
                matricula = sc.nextInt();
                System.out.println("NOMBRE:");
                System.out.print("->");
                sc.nextLine();
                nombre = sc.nextLine();
                System.out.println("CARRERA:");
                System.out.print("->");
                carrera = sc.nextLine();
                Servicio.crear(matricula,nombre,carrera,url);
                System.out.println("ESTUDIANTE CREADO CON EXITO");
            } else if (decision == 4) {
                System.out.println("MATRICULA DEL ESTUDIANTE:");
                System.out.print("->");
                matricula = sc.nextInt();
                Servicio.borrar(matricula,url);
                System.out.println("ESTUDIANTE BORRADO CON EXITO");
            } else {
                System.out.println("OPCION NO VALIDA");
            }

        }while(decision != 0);

    }




}
