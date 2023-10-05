package com.example.basecompra.services;

import com.example.basecompra.utilities.AuthToken;
import com.example.basecompra.utilities.paypal.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotificacionService {
    //region variables
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificacionService.class);

    @Value("${proyecto.api.url}")
    private String apiUrl;

    @Value("${proyecto.robot.user}")
    private String apiUser;
    @Value("${proyecto.robot.pwd}")
    private String apiPwd;

    private AuthToken authToken;

    private RestTemplate restTemplate;

    @Autowired
    public NotificacionService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //endregion

    public ResponseEntity<Object> makeRequest(String path, HttpMethod method, Object body, Class clase) {
        if(authToken==null)
            renewToken();
        HttpHeaders headers = new HttpHeaders() {{
            setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            setBearerAuth(authToken.getAccessToken());
            setContentType(MediaType.APPLICATION_JSON);
        }};
        HttpEntity<Object> request = null;
        if (body == null) {
            request = new HttpEntity(headers);
        } else {
            request = new HttpEntity(body, headers);
        }
        ResponseEntity<Object> responseEntity = null;
        int retries = 2;
        while (retries-- > 0) {
            try {
                responseEntity = restTemplate.exchange(apiUrl + path, method, request, clase);
                break;
            } catch (HttpStatusCodeException e) {
                if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                    renewToken();
                    headers.setBearerAuth(authToken.getAccessToken());
                } else {
                    throw e;
                }

            }
        }
        return responseEntity;
    }

    private void renewToken() {
        HttpHeaders headers = new HttpHeaders() {{
            setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        }};
        authToken = restTemplate.postForObject(
                apiUrl + "/api/auth/login",
                new HttpEntity<>(
                        new LinkedMultiValueMap<>() {{
                            add("username", apiUser);
                            add("password", apiPwd);
                        }},
                        headers
                ),
                AuthToken.class
        );
        LOGGER.info("Notificacion token renewed.");
    }

}
