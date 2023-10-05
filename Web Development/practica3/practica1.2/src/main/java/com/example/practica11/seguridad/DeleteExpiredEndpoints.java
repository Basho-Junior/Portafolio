package com.example.practica11.seguridad;

import com.example.practica11.entidades.MockEndpoint;
import com.example.practica11.entidades.repositorios.MockEndpointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;

@Service
@Transactional
public class DeleteExpiredEndpoints {
    @Autowired
    MockEndpointRepo mockEndpointRepo;

    @Scheduled(cron = "0 0 5 * * ?")
    public void deleteExpiredEndpoints() {
        mockEndpointRepo.deleteAllByExpirationLessThan(Timestamp.from(Instant.now()));
    }

}
