package com.example.practica2jms.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
