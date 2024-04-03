package com.vinimanfrin.autentication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/hello") //simula um end point que não requer nenhuma autenticação
    public ResponseEntity helloWorld(){
        var message = "Hello World";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/private") //simula um end point que requer autenticação
    public ResponseEntity privateRoute(){
        var message = "Esse é o método que requer autenticação";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/admin") //simula um end point que requer autenticação e permissão de administrador
    public ResponseEntity adminRoute(){
        var message = "Esse é o método que requer autenticação e permissão de admin";
        return ResponseEntity.ok(message);
    }
}
