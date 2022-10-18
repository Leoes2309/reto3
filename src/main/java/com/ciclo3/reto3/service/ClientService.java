package com.ciclo3.reto3.service;

import com.ciclo3.reto3.entities.Client;
import com.ciclo3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> e = clientRepository.getClient(c.getIdClient());
            if(e.isPresent()){
                return c;
            }else{
                return clientRepository.save(c);
            }
        }
    }
    public Client updateClient(Client client) {

        if (client.getIdClient() != null) {
            Optional<Client> clientU = clientRepository.getClient(client.getIdClient());

            if (!clientU.isEmpty()) {

                for (Field f : client.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(client);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(clientU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return clientRepository.save(clientU.get());
        }
        return client;
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>c= clientRepository.getClient(id);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            flag=true;
        }
        return flag;

    }
    public boolean deleteClient(int id) {
        Optional<Client> clientd = clientRepository.getClient(id);
        if (clientd.isEmpty()) {
            return false;
        } else {
            clientRepository.delete(clientd.get());
            return true;
        }
    }

}