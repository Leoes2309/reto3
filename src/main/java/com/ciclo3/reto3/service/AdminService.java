package com.ciclo3.reto3.service;

import com.ciclo3.reto3.entities.Admin;
import com.ciclo3.reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a){
        if (a.getIdAdmin() == null){
            return adminRepository.save(a);
        } else {
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(a.getIdAdmin());
            if (adminEncontrado.isEmpty()){
                return adminRepository.save(a);
            }else {
                return a;
            }
        }
    }
    public Admin update(Admin a){
        if (a.getIdAdmin() != null){
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(a.getIdAdmin());
            if (!adminEncontrado.isEmpty()) {
                if (a.getPassword() != null) {
                    adminEncontrado.get().setPassword(a.getPassword());
                }

                if (a.getName() != null){
                    adminEncontrado.get().setName(a.getName());
                }
                return adminRepository.save(adminEncontrado.get());
            }
        }
        return a;
    }
    public boolean deleteAdmin(int adminId){
        Boolean resultado = getAdmin(adminId).map(adminPorEliminar ->{
            adminRepository.delete(adminPorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
}

