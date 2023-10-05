package com.example.basecompra.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion {
    private long id;
    private String nombre;
    private String username;
    private Date fecha;
    private String paquete;
    private String mensaje;
}
