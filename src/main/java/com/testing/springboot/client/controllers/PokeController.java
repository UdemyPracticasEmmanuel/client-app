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

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@CrossOrigin(origins = {"http://localhost:9000"})
@RestController
@RequestMapping("/pokemon")
public class PokeController {
    @Autowired
    PokeService pokeService;

    String ivString = "1234567890123456";
    String secret = "UjXn2r5u8x/A?D(G";
    //String message = "Hello AES World!";

    private static RestTemplate rest = new RestTemplate();

    @GetMapping("/{name}")
    public Map<String, String> getPokemonByName(@PathVariable String name){
        return pokeService.getPokemonByName(name);
    }
    public String getToken(String code){
        return pokeService.getToken(code);
    }

    @GetMapping("/aes")
    public String encryptAes(@RequestParam String message) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte[] encrypted = pokeService.encryptAes(message, ivString, secret);
        System.out.println("Encrypted: " + encrypted.toString());

        return new String(encrypted);
    }

    //Endpoints para fines de pruebas: list y create
    @GetMapping("/list")
    public List<Message> list(){
        return Collections.singletonList(new Message("Test Pokelist"));
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("mensaje guardado: " + message);
        return message;
    }
    //TODO: Decrypted en construcción
    @GetMapping("/aes-2")
    public String decryptAes(byte[] encrypted) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return pokeService.decryptAes(encrypted, ivString, secret);
    }


}
