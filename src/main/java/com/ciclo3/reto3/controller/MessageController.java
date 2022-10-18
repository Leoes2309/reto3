package com.ciclo3.reto3.controller;

import com.ciclo3.reto3.entities.Category;
import com.ciclo3.reto3.entities.Message;
import com.ciclo3.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    @GetMapping("/{id}")

    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }

    @PostMapping("/save")
    public  Message save(@RequestBody Message m){
        return messageService.save(m);
    }

    @PutMapping("/update")
    public  Message update(@RequestBody Message m){
        return  messageService.save(m);
    }
}
