package com.testing.springboot.client.services;
import com.testing.springboot.client.models.PokeDex;
import com.testing.springboot.client.models.TokenResponse;
import org.apache.coyote.Response;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeService {
    private static RestTemplate rest = new RestTemplate();
    String URL_PKM = "https://pokeapi.co/api/v2/pokemon/";
    String URL_TOKEN= "http://127.0.0.1:9000/oauth2/token";
    String REDIRECT_URI= "http://127.0.0.1:8080/authorized";

    String REDIRECT_POKE= "http://127.0.0.1:8080/pokemon/";

    public Map<String, String> getPokemonByName(String name){
        ResponseEntity<PokeDex> response = rest.exchange(URL_PKM + name, HttpMethod.GET, null, PokeDex.class);
        PokeDex pokemon = response.getBody();
        return pokemon.getPkm();
    }
    public Map<String, String> getPokemonTokenByName(String name, String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        /*
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("redirect_uri", REDIRECT_POKE + name);*/

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null, headers);
        ResponseEntity<PokeDex> response = rest.exchange(URL_PKM + name, HttpMethod.GET, request, PokeDex.class);
        PokeDex pokemon = response.getBody();
        return pokemon.getPkm();
    }
    public String getToken(String code){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("client-app", "12345");

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("code", code);
        map.add("grant_type", "authorization_code");
        map.add("redirect_uri", REDIRECT_URI);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<TokenResponse> postResponse = rest.postForEntity( URL_TOKEN, request , TokenResponse.class );
        TokenResponse tokenResponse = postResponse.getBody();
        System.out.println(tokenResponse);

        return tokenResponse.getAccess_token();
    }


}
