package com.ciclo3.reto3.service;

import com.ciclo3.reto3.entities.Bike;
import com.ciclo3.reto3.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll() {return bikeRepository.getAll();}
    public Optional<Bike> getBike(int id) {return bikeRepository.getBike(id);}

    public Bike save(Bike b) {
        if (b.getId() == null) {
            return bikeRepository.save(b);
        } else {
            Optional<Bike> bikeEncontrado = bikeRepository.getBike(b.getId());
            if (bikeEncontrado.isEmpty()) {

                return bikeRepository.save(b);
            } else {
                return b;
            }
        }
    }

    public Bike update(Bike b) {
        if (b.getId() != null) {
            Optional<Bike> bikeEncontrado = bikeRepository.getBike(b.getId());
            if (!bikeEncontrado.isEmpty()) {//Aqui niego este bolean Y se verifica que no este vacio
                if (b.getName() != null) {
                    bikeEncontrado.get().setName(b.getName());
                }
                if (b.getBrand() != null) {
                    bikeEncontrado.get().setBrand(b.getBrand());
                }
                if (b.getYear() != null) {
                    bikeEncontrado.get().setYear(b.getYear());
                }
                if (b.getDescription() != null) {
                    bikeEncontrado.get().setDescription(b.getDescription());
                }
                if (b.getCategory() != null) {
                    bikeEncontrado.get().setCategory(b.getCategory());
                }
                return bikeRepository.save(bikeEncontrado.get());
            }
        }
        return b;
    }

    public boolean delete(int bikeId) {
        Boolean resultado = getBike(bikeId).map(bikePorEliminar -> {
            bikeRepository.delete(bikePorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
}