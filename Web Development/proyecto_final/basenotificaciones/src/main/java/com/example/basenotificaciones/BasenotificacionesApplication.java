package com.example.basenotificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableRetry
public class BasenotificacionesApplication {
	public static void main(String[] args) {
		SpringApplication.run(BasenotificacionesApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}
}
