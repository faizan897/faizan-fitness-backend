package com.faizan.fitness.backend;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/hello")
    public String sayHello() {
        return "✅ Backend is working!";
    }
}
