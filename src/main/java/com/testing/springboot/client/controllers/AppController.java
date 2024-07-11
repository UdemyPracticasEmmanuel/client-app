package com.testing.springboot.client.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = {"http://localhost:9000"})
@RestController
public class AppController {
    @Autowired
    PokeController pokeController;

    @RequestMapping("/authorized")
    public String authorized(@RequestParam String code){
        String token = pokeController.getToken(code);
        return token;
    }
}

