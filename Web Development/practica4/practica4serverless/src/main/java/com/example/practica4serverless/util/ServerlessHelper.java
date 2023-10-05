package com.example.practica4serverless.util;

public class ServerlessHelper {
    public enum VariableAmbienteA {
        TABLA("TABLA_RESERVA");
        private String valor;
        VariableAmbienteA(String valor) {
            this.valor = valor;
        }
        public String getValor() {
            return valor;
        }
    }
    public enum VariableAmbienteB {
        TABLA("TABLA_LABORATORIO");
        private String valor;
        VariableAmbienteB(String valor) {
            this.valor = valor;
        }
        public String getValor() {
            return valor;
        }
    }
}
