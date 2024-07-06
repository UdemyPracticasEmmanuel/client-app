package com.testing.springboot.client.services;
import com.testing.springboot.client.models.PokeDex;
import com.testing.springboot.client.models.TokenResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeService {
    private static RestTemplate rest = new RestTemplate();

    @Value("${spring.application.name}")
    private String appUser;

    @Value("${app.password}")
    private String appPass;

    @Value("${app.pokeApi}")
    private String URL_PKM;

    @Value("${app.token}")
    private String URL_TOKEN;

    @Value("${app.redirectUri}")
    private String REDIRECT_URI;

    public Map<String, String> getPokemonByName(String name){
        ResponseEntity<PokeDex> response = rest.exchange(URL_PKM + name, HttpMethod.GET, null, PokeDex.class);
        PokeDex pokemon = response.getBody();
        return pokemon.getPkm();
    }
    public String getToken(String code){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(appUser, appPass);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("code", code);
        map.add("grant_type", "authorization_code");
        map.add("redirect_uri", REDIRECT_URI);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<TokenResponse> postResponse = rest.postForEntity( URL_TOKEN, request , TokenResponse.class );
        TokenResponse tokenResponse = postResponse.getBody();
        //System.out.println(tokenResponse);

        return tokenResponse.getAccess_token();
    }


}
