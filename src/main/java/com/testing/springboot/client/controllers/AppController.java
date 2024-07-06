package com.testing.springboot.client.controllers;
import com.testing.springboot.client.models.Message;
import com.testing.springboot.client.services.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = {"http://localhost:9000"})
@RestController
@Controller
public class AppController {
    @Autowired
    PokeController pokeController;
    /*
    @GetMapping("/list")
    public List<Message> list(){
        return Collections.singletonList(new Message("Test list"));
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("mensaje guardado: " + message);
        return message;
    }

    @GetMapping("/authorized")
    public String authorized(@RequestParam String code){
        String token = pokeController.getToken(code);

        //Map<String, String> codeMap= new LinkedHashMap<String, String>();
        //codeMap.put("code", token);

        return "redirect:/pokemon/list?token=" + token;
    }
*/
    @RequestMapping("/authorized")
    public String authorized(@RequestParam String code){
        //System.out.println("Token es:");
        String token = pokeController.getToken(code);

        //TODO: Redireccionar a /pokemon/ditto o que solo muestre el token

        //RedirectView redirectView = new RedirectView();
        //redirectView.setUrl("/pokemon/ditto?token=" + token);

        return token;
    }
}

