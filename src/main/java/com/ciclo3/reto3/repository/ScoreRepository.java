package com.ciclo3.reto3.repository;

import com.ciclo3.reto3.entities.Score;
import com.ciclo3.reto3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository gameCrudRepository;

    public List<Score> getAll(){

        return (List<Score>) gameCrudRepository.findAll();
    }

    public Optional<Score> getGame(int id){
        return gameCrudRepository.findById(id);
    }

    public Score save(Score g){

        return gameCrudRepository.save(g);
    }

    public void delete(Score g){

        gameCrudRepository.delete(g);
    }
}
