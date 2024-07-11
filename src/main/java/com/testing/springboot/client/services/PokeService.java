package com.testing.springboot.client.services;
import com.testing.springboot.client.models.PokeDex;
import com.testing.springboot.client.models.TokenResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

@Service
public class PokeService {
    private static RestTemplate rest = new RestTemplate();
    private String appUser = "client-app";
    private String appPass = "12345";
    private String URL_PKM = "https://pokeapi.co/api/v2/pokemon/";
    private String URL_TOKEN = "http://127.0.0.1:9000/oauth2/token";
    private String REDIRECT_URI = "http://127.0.0.1:8080/authorized";

    public Map<String, String> getPokemonByName(String name){
        Map<String, String> pokeMap = new LinkedHashMap<String, String>();
          try {
            ResponseEntity<PokeDex> response = rest.exchange(URL_PKM + name, HttpMethod.GET, null, PokeDex.class);
            PokeDex pokemon = response.getBody();
            pokeMap = pokemon.getPkm();
        } catch(Exception e) {
            pokeMap.put("Estatus de búsqueda", name + " " + e.getMessage());
        } finally {
            return pokeMap;
        }

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

    public byte[] encryptAes(String message, String ivString, String secret) throws UnsupportedEncodingException {
        try {
            IvParameterSpec iv = new IvParameterSpec(ivString.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            return cipher.doFinal(message.getBytes("UTF-8"));

        }catch(Exception e){
            return ("Resultado Encriptación" + e.getMessage()).getBytes("UTF-8");
        }
    }
    public String decryptAes(byte[] encrypted, String initVector, String key) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

        byte[] original = cipher.doFinal(encrypted); //(Base64.getDecoder().decode(encrypted));
        return new String(original);
    }


}
