package com.example.ServerlessAws.util;

public class ServerlessHelper {

    public enum VariableAmbienteA{
        TABLA("TABLA_RESERVA");
        private String valor;
        VariableAmbienteA(String valor) {
            this.valor = valor;
        }
        public String getValor() {
            return valor;
        }
    }

    public enum VariableAmbienteB{
        TABLA("TABLA_LABORATORIO");
        private String valor;
        VariableAmbienteB(String valor) {
            this.valor = valor;
        }
        public String getValor() {
            return valor;
        }
    }
    // Tabla para las reservas.
    public static String getNombreTablaA(){
        return System.getenv(VariableAmbienteA.TABLA.getValor());
    }
    // Tabla para los laboratorios.
    public static String getNombreTablaB(){
        return System.getenv(VariableAmbienteB.TABLA.getValor());
    }
}
