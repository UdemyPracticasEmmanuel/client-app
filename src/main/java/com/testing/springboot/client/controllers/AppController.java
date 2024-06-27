package com.testing.springboot.client.controllers;
import com.testing.springboot.client.models.Message;
import com.testing.springboot.client.services.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AppController {
    @Autowired
    PokeService pokeService;

    @Autowired
    PokeController pokeController;

    @GetMapping("/list")
    public List<Message> list(){
        return Collections.singletonList(new Message("Test list"));
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("mensaje guardado: " + message);
        return message;
    }
/*
* Función para autenticarse y obtener token, con el cuál poder acceder a los endpoints '/list' y '/create'
* */
    @GetMapping("/authorized")
    public Map<String, String> authorized(@RequestParam String code){
        String token = getToken(code); //Redirigir a pokemon/ditto, usando este token
        Map<String, String> pokeMap= pokeController.getPokemonTokenByName("ditto", token);
        return pokeMap;
    }

    public String getToken(String code){
        return pokeService.getToken(code);
    }

}

