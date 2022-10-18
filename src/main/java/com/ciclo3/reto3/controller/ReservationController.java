package com.ciclo3.reto3.controller;

import com.ciclo3.reto3.entities.Category;
import com.ciclo3.reto3.entities.Reservation;
import com.ciclo3.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    public  Reservation save(@RequestBody Reservation r){
        return  reservationService.save(r);
    }

    @PutMapping("/update")
    public  Reservation update(@RequestBody Reservation r){
        return  reservationService.save(r);
    }
}