package com.testing.springboot.client.controllers;

import com.testing.springboot.client.models.Message;
import com.testing.springboot.client.models.PokeDex;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class AppController {
    @GetMapping("/list")
    public List<Message> list(){
        return Collections.singletonList(new Message("Test list"));
    }
    @GetMapping("/pokemon/{requestedId}")
    private ResponseEntity<PokeDex> findById(@PathVariable String requestedId) {
        if (requestedId.equals("ditto")) {
            PokeDex pokeDex = new PokeDex("ditto");
            return ResponseEntity.ok(pokeDex);
        } else {
            return ResponseEntity.notFound().build();
        }
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
        return Collections.singletonMap("code", code);
    }
}

