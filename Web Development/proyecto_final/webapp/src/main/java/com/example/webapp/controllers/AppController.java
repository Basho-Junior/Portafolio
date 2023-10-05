package com.example.webapp.controllers;

import com.example.webapp.utilities.Servicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AppController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }
        return "login";
    }

    /*@RequestMapping("/logout")
    public String logout() {
        return "redirect:/";
    }*/
    @RequestMapping("/registrar")
    public String registro() {
        return "registrar";
    }

    @RequestMapping("/verifyAuthentication")
    public String autenticacion() {
        log.info("Redirect a: /");
        return "redirect:/";
    }

}
