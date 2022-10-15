package com.ciclo3.reto3.controller;

import com.ciclo3.reto3.entities.Score;
import com.ciclo3.reto3.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Game")
public class ScoreController {

    @Autowired
    private GameService gameService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return gameService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id){
        return gameService.getGame(id);
    }

    @PostMapping("/save")
    public  Score save(@RequestBody Score score){
        return  gameService.save(score);
    }

    @PutMapping("/update")
    public  Score update(@RequestBody Score score){
        return  gameService.save(score);
    }
}