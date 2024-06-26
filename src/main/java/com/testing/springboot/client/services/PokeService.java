package com.testing.springboot.client.services;
import com.testing.springboot.client.models.PokeDex;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeService {
    private static RestTemplate rest = new RestTemplate();
    String URL_PKM = "https://pokeapi.co/api/v2/pokemon/";

    public Map<String, String> getPokemonByName(String name){
        ResponseEntity<PokeDex> response = rest.exchange(URL_PKM + name, HttpMethod.GET, null, PokeDex.class);
        PokeDex pokemon = response.getBody();
        return pokemon.getPkm();
    }


}
