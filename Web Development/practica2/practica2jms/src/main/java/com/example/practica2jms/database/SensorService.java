package com.example.practica2jms.database;

import com.example.practica2jms.objetos.Info;
import org.springframework.stereotype.Service;

public interface SensorService {
    public boolean saveData(Info info);
}
