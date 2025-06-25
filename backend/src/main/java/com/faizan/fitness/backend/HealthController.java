package com.faizan.fitness.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/hello")
    public String sayHello() {
        return "✅ Backend is working!";
    }

    @PostMapping("/bmr")
    public double calculateBMR(@RequestBody UserData userData) {
        double bmr;

        if ("Male".equalsIgnoreCase(userData.getGender())) {
            bmr = 10 * userData.getWeight() + 6.25 * userData.getHeight() - 5 * userData.getAge() + 5;
        } else {
            bmr = 10 * userData.getWeight() + 6.25 * userData.getHeight() - 5 * userData.getAge() - 161;
        }

        double multiplier = switch (userData.getLifestyle().toLowerCase()) {
            case "sedentary" -> 1.2;
            case "lightly active" -> 1.375;
            case "moderately active" -> 1.55;
            case "very active" -> 1.725;
            case "extra active" -> 1.9;
            default -> 1.2;
        };

        return bmr * multiplier;
    }
}
