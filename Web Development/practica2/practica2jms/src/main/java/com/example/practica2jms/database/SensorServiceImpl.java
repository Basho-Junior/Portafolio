package com.example.practica2jms.database;

import com.example.practica2jms.objetos.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public boolean saveData(Info info) {
        Sensor sensor = new Sensor(info.getFechaGeneracion(), info.getTemperatura(), info.getHumedad());
        sensorRepository.save(sensor);
        return true;
    }
}
