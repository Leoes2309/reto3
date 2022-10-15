package com.ciclo3.reto3.repository.crudRepository;

import com.ciclo3.reto3.entities.Bike;
import com.ciclo3.reto3.repository.crudRepository.BikeCrudRepository;
import org.springframework.data.repository.CrudRepository;

public interface BikeCrudRepository extends CrudRepository<Bike,Integer> {
}
