package com.testing.springboot.client.controllers;

import com.testing.springboot.client.models.Message;
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

    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("mensaje guardado: " + message);
        return message;
    }

    public Map<String, String> authorized(@RequestParam String code){
        return Collections.singletonMap("code", code);
    }
}

