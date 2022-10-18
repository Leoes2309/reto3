/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.reto3.entities;

import com.ciclo3.reto3.entities.Message;
import com.ciclo3.reto3.entities.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa a un disfraz de los que se rentan en la tienda
 * @author desaextremo
 */
@Entity
@Table(name = "bike")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column (nullable = false, length = 40) 
    private String brand;
    @Column (nullable = false)
    private Integer year;
    @Column (nullable = false, length = 250)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("bikes")
    private Category category;
    
    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike","client"})
    private List <Message> messages;
    
    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "messages"})
    private List <Reservation> reservations;
    
}
