package com.testing.springboot.client.controllers;
import com.testing.springboot.client.services.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/pokemon")
public class PokeController {
    @Autowired
    PokeService pokeService;
/*
    @GetMapping("{name}")
    public Map<String, String> getPokemonByName(@PathVariable String name){
        return pokeService.getPokemonByName(name);
    }
*/
    @GetMapping("{name}")
    public Map<String, String> getPokemonTokenByName(@PathVariable String name, String token){
        return pokeService.getPokemonTokenByName(name, token);
    }
}
