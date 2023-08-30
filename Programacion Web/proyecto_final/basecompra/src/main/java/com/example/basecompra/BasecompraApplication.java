package com.example.basecompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableEurekaClient
@EnableRetry
public class BasecompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasecompraApplication.class, args);
	}

}
