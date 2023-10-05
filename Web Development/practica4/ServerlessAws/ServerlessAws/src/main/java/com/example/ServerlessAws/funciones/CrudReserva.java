package com.example.ServerlessAws.funciones;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.example.ServerlessAws.encapsulaciones.ListarReservasResponse;
import com.example.ServerlessAws.encapsulaciones.Reserva;
import com.example.ServerlessAws.servicios.DynamoDBServices;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class CrudReserva implements RequestStreamHandler {
    //Instanciando objeto el manejo de la base de datos.
    private DynamoDBServices dynamoDBServices = new DynamoDBServices();
    private Gson gson = new Gson();

    /**
     * Handler para crud de reservas.
     * @param input
     * @param output
     * @param context
     * @throws IOException
     */
    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        //Objetos para el control de la salida.
        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String cuerpoRecibido = null;
        JSONObject responseJson = new JSONObject();
        String salida = "";
        Reserva reserva = null;
        //
        try {
            //Parseando el objeto.
            JSONObject evento = (JSONObject) parser.parse(reader);

            //Ver la salida por la consola sobre la trama enviada por el APIGateway
            context.getLogger().log(""+evento.toJSONString());

            //Recuperando el metodo de acceso de la llamada del API.
            if(evento.get("requestContext")==null){
                throw new IllegalArgumentException("No respuesta el API de entrada");
            }
            String metodoHttp = ((JSONObject)((JSONObject)evento.get("requestContext")).get("http")).get("method").toString();
            //Realizando la operacion
            switch (metodoHttp){
                case "GET":
                    ListarReservasResponse listarReservasResponse = dynamoDBServices.listarReservas(context);
                    salida = gson.toJson(listarReservasResponse);
                    break;
                case "POST":
                case "PUT":
                    reserva = getReservaBodyJson(evento);
                    dynamoDBServices.insertarReservaTabla(reserva, context);
                    salida = gson.toJson(reserva);
                    break;
                case "DELETE":
                    reserva = getReservaBodyJson(evento);
                    dynamoDBServices.eliminarReserva(reserva, context);
                    salida = gson.toJson(reserva);
                    break;
            }

            //La información enviada por el metodo Post o Put estará disponible en la propiedad body:
            if(evento.get("body")!=null){
                cuerpoRecibido = evento.get("body").toString();
            }

            //Respuesta en el formato esperado:
            JSONObject responseBody = new JSONObject();
            responseBody.put("data", JsonParser.parseString(salida));
            responseBody.put("entrada", cuerpoRecibido);

            JSONObject headerJson = new JSONObject();
            headerJson.put("mi-header", "Mi propio header");
            headerJson.put("Content-Type", "application/json");

            responseJson.put("statusCode", 200);
            responseJson.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());

        }catch (Exception ex){
            responseJson.put("statusCode", 400);
            responseJson.put("exception", ex);
        }

        //Salida
        OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }

    /**
     *
     * @param json
     * @return
     */
    private Reserva getReservaBodyJson(JSONObject json) throws IllegalArgumentException {
        if(json.get("body")==null){
            throw new IllegalArgumentException("No envió el cuerpo en la trama.");
        }
        Reserva reserva =gson.fromJson(json.get("body").toString(), Reserva.class);
        return reserva;
    }
}
