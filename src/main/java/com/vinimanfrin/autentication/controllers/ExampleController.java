package com.vinimanfrin.autentication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/hello") //End point que não requer nenhuma autenticação
    public ResponseEntity helloWorld(){
        var message = "Hello World";
        return ResponseEntity.ok(message);
    }

}
