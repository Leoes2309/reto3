package com.ciclo3.reto3.controller;

import com.ciclo3.reto3.entities.Score;
import com.ciclo3.reto3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Game")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    public  Score save(@RequestBody Score score){
        return  scoreService.save(score);
    }

    @PutMapping("/update")
    public  Score update(@RequestBody Score score){
        return  scoreService.save(score);
    }
}
