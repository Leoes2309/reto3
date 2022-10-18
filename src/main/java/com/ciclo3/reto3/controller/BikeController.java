package com.ciclo3.reto3.controller;

import com.ciclo3.reto3.entities.Bike;
import com.ciclo3.reto3.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getAll(){
        return bikeService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike c){
        return bikeService.save(c);
    }


}

