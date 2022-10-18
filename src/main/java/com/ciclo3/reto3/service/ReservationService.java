package com.ciclo3.reto3.service;

import com.ciclo3.reto3.entities.Reservation;
import com.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation a){
        if (a.getIdReservation() == null){
            return reservationRepository.save(a);
        } else {
            Optional<Reservation> reservaEncontrado = reservationRepository.getReservation(a.getIdReservation());
            if (reservaEncontrado.isEmpty()){
                return reservationRepository.save(a);
            }else {
                return a;
            }
        }
    }
    public Reservation update(Reservation re){
        if (re.getIdReservation() != null){
            Optional<Reservation> reservaEncontrada = reservationRepository.getReservation(re.getIdReservation());
            if (!reservaEncontrada.isEmpty()) {
                if (re.getStartDate() != null) {
                    reservaEncontrada.get().setStartDate(re.getStartDate());
                }
                if (re.getStatus() != null){
                    reservaEncontrada.get().setStatus(re.getStatus());
                }
                if (re.getDevolutionDate() != null){
                    reservaEncontrada.get().setDevolutionDate(re.getDevolutionDate());
                }
                return reservationRepository.save(reservaEncontrada.get());
            }
        }
        return re;
    }
}
