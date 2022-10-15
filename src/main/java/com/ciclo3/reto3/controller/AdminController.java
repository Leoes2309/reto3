package com.ciclo3.reto3.controller;

import com.example.proyectomictic.entities.Admin;
import com.example.proyectomictic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    // /api/Admin/all
    @GetMapping("/all")
    public List<Admin>getAll(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    // public Optional<Admin>getAdmin(@PathVariable("id") int id,@PathVariable("var2") String var2){}//cuando adiciono mas variables
    public Optional<Admin>getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }
    // /api/Admin/save
    @PostMapping("/save")
    public  Admin save(@RequestBody Admin a){
        return  adminService.save(a);
    }
    // /api/Admin/update
    @PutMapping("/update")
    public  Admin update(@RequestBody Admin a){
        return  adminService.save(a);
    }
/*
    // /api/Admin/delete
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idAdmin){
        return adminService.getAdmin(idAdmin);
    }

 */

}
