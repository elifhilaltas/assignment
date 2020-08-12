package com.assignment.bsp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomePage {

    @GetMapping
       public String merhaba() {
        return "Hello! I'm Elif Hilal. Its my Spring Project for Subscreasy.";
    }
}
