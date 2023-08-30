package com.example.baseusuario.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";

    }

    @RequestMapping("/name")
    public String name(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello " + name;
    }
}
