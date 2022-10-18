package com.ciclo3.reto3.controller;

import com.ciclo3.reto3.entities.Admin;
import com.ciclo3.reto3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin>getAll(){
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin>getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }

    @PostMapping("/save")
    public  Admin save(@RequestBody Admin a){
        return  adminService.save(a);
    }

    @PutMapping("/update")
    public  Admin update(@RequestBody Admin a){
        return  adminService.save(a);
    }
}
