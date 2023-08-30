package com.example.ServerlessAws.servicios;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.example.ServerlessAws.encapsulaciones.*;
import com.example.ServerlessAws.util.ServerlessHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamoDBServices {
    //Opciones para insertar y eliminar
    // Reservas
    public ReservaResponse insertarReservaTabla (Reserva reserva, Context context) {
        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();
        // Si no tiene a nadie en la reserva...
        if(reserva.getNombre().isEmpty()){
            throw new RuntimeException("Datos enviados no son validos");
        }
        // Intentar guardar.
        try {
            DynamoDBMapper mapper = new DynamoDBMapper(ddb);
            mapper.save(reserva);
        }catch (Exception e){
            return new ReservaResponse(true, e.getMessage(), null);
        }
        return new ReservaResponse(false, null, reserva);
    }

    public ReservaResponse eliminarReserva(Reserva reserva, Context context){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        // Obtener nombre de variable de ambiente de la tabla de reservas.
        Table table = dynamoDB.getTable(ServerlessHelper.getNombreTablaA());
        // Eliminar item.
        DeleteItemOutcome outcome = table.deleteItem("id", reserva.getId());
        return new ReservaResponse(false, null, reserva);
    }
    // Laboratorios
    public LaboratorioResponse insertarLaboratorioTabla (Laboratorio laboratorio, Context context) {
        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();
        // Si no tiene a nadie en la reserva...
        if(laboratorio.getNombre().isEmpty()){
            throw new RuntimeException("Datos enviados no son validos");
        }
        // Intentar guardar.
        try {
            DynamoDBMapper mapper = new DynamoDBMapper(ddb);
            mapper.save(laboratorio);
        }catch (Exception e){
            return new LaboratorioResponse(true, e.getMessage(), null);
        }
        return new LaboratorioResponse(false, null, laboratorio);
    }

    public LaboratorioResponse eliminarLaboratorio(Laboratorio laboratorio, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        // Obtener nombre de variable de ambiente de la tabla de reservas.
        Table table = dynamoDB.getTable(ServerlessHelper.getNombreTablaB());
        // Eliminar item.
        DeleteItemOutcome outcome = table.deleteItem("id", laboratorio.getId());
        return new LaboratorioResponse(false, null, laboratorio);
    }

    public ListarReservasResponse listarReservas (Context context) {
        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        List<Reserva> reservas = new ArrayList<>();
        ScanRequest scanRequest = new ScanRequest().withTableName(ServerlessHelper.getNombreTablaA());
        ScanResult result = null;
        do {
            // Iterar ScanResult porque solo retorna 1MB en total.
            if (result != null) {
                scanRequest.setExclusiveStartKey(result.getLastEvaluatedKey());
            }

            result = ddb.scan(scanRequest);
            List<Map<String, AttributeValue>> rows = result.getItems();

            // Iterar todos los elementos
            for (Map<String, AttributeValue> mapEstudiantes : rows) {
                System.out.println(""+mapEstudiantes);
                //
                AttributeValue idAttributo = mapEstudiantes.get("id");
                AttributeValue idEstudianteAtributo = mapEstudiantes.get("idEstudiante");
                AttributeValue nombreAtributo = mapEstudiantes.get("nombre");
                AttributeValue carreraAtributo = mapEstudiantes.get("carrera");
                AttributeValue laboratorioAtributo = mapEstudiantes.get("laboratorio");
                AttributeValue fechaAtributo = mapEstudiantes.get("fecha");
                //
                Reserva tmp = new Reserva();
                tmp.setId(idAttributo.getS());
                if(idEstudianteAtributo!=null){
                    tmp.setIdEstudiante(idEstudianteAtributo.getS());
                }
                if(nombreAtributo!=null){
                    tmp.setNombre(nombreAtributo.getS());
                }
                if(carreraAtributo!=null){
                    tmp.setCarrera(carreraAtributo.getS());
                }
                if(laboratorioAtributo!=null){
                    tmp.setLaboratorio(laboratorioAtributo.getS());
                }
                if(fechaAtributo!=null){
                    tmp.setFecha(fechaAtributo.getS());
                }
                reservas.add(tmp);
            }

        } while (result.getLastEvaluatedKey() != null);

        return new ListarReservasResponse(false, "", reservas);
    }

    public ListarLaboratoriosResponse listarLaboratorios (Context context) {
        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        List<Laboratorio> laboratorios = new ArrayList<>();
        ScanRequest scanRequest = new ScanRequest().withTableName(ServerlessHelper.getNombreTablaB());
        ScanResult result = null;
        do {
            // Iterar ScanResult porque solo retorna 1MB en total.
            if (result != null) {
                scanRequest.setExclusiveStartKey(result.getLastEvaluatedKey());
            }

            result = ddb.scan(scanRequest);
            List<Map<String, AttributeValue>> rows = result.getItems();

            // Iterar todos los elementos
            for (Map<String, AttributeValue> mapEstudiantes : rows) {
                System.out.println(""+mapEstudiantes);
                //
                AttributeValue idAttributo = mapEstudiantes.get("id");
                AttributeValue nombreAtributo = mapEstudiantes.get("nombre");
                AttributeValue cantidadMaximaAtributo = mapEstudiantes.get("cantidadMaxima");
                //
                Laboratorio tmp = new Laboratorio();
                tmp.setId(idAttributo.getS());
                if(nombreAtributo!=null){
                    tmp.setNombre(nombreAtributo.getS());
                }
                if(cantidadMaximaAtributo!=null){
                    tmp.setCantidadMaxima(cantidadMaximaAtributo.getS());
                }
                laboratorios.add(tmp);
            }

        } while (result.getLastEvaluatedKey() != null);

        return new ListarLaboratoriosResponse(false, "", laboratorios);
    }
}
