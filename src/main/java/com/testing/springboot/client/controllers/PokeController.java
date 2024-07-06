package com.testing.springboot.client.controllers;
import com.testing.springboot.client.models.Message;
import com.testing.springboot.client.models.PokeDex;
import com.testing.springboot.client.models.TokenResponse;
import com.testing.springboot.client.services.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@CrossOrigin(origins = {"http://localhost:9000"})
@RestController
@RequestMapping("/pokemon")
public class PokeController {
    @Autowired
    PokeService pokeService;

    private static RestTemplate rest = new RestTemplate();

    @GetMapping("{name}")
    public Map<String, String> getPokemonByName(@PathVariable String name){
        return pokeService.getPokemonByName(name);
    }

    /*
    @GetMapping("{name}")
    public ResponseEntity<Map<String, String>> getPokemonByName(@PathVariable String name, @RequestParam String token){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        responseHeaders.setBearerAuth(token);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(pokeService.getPokemonByName(name));
    }
    */
    public String getToken(String code){
        return pokeService.getToken(code);
    }




    @GetMapping("/list")
    public List<Message> list(){
        return Collections.singletonList(new Message("Test Pokelist"));
    }

/*
    @GetMapping("/list")
    public ResponseEntity<String> list(@RequestParam String token){
        System.out.println("Hello pokeworld");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        responseHeaders.setBearerAuth(token);


        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Hello");
    }
*/
    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("mensaje guardado: " + message);
        return message;
    }


}
