package com.ciclo3.reto3.repository;

import com.ciclo3.reto3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {

    @Autowired
    private ScoreCrudRepository gameCrudRepository;

    public List<Game> getAll(){

        return (List<Game>) gameCrudRepository.findAll();
    }

    public Optional<Game> getGame(int id){
        return gameCrudRepository.findById(id);
    }

    public Game save(Game g){

        return gameCrudRepository.save(g);
    }

    public void delete(Game g){

        gameCrudRepository.delete(g);
    }
}
