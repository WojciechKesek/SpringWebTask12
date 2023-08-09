package com.example.springwebtask12.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

    @GetMapping("/api/cars")
    public String getCars(){
        return "Get all cars";
    }
    @PostMapping("/api/cars")
    public String createCar(){
        return "Car created";
    }

    @GetMapping("/api/users/test")
    public String getUsers(){
        return "Get users";
    }

    @GetMapping
    public String hello(){
        return "Hello!";
    }

}
