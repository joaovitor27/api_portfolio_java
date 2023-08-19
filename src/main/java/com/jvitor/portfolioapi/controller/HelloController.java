package com.jvitor.portfolioapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {
    @PostMapping
    public void hello(@RequestBody String teste) {
        System.out.println(teste);
    }
}

