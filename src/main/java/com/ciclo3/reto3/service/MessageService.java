package com.ciclo3.reto3.service;

import com.ciclo3.reto3.entities.Message;
import com.ciclo3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getAll(){
        return (List<Message>) messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        } else {
            Optional<Message> adminEncontrado = messageRepository.getMessage(message.getIdMessage());
            if (adminEncontrado.isEmpty()){
                return messageRepository.save(message);
            }else {
                return message;
            }
        }
    }
    public Message update(Message message){
        if (message.getIdMessage() != null){
            Optional<Message> messageEncontrado = messageRepository.getMessage(message.getIdMessage());
            if (!messageEncontrado.isEmpty()) {
                if (message.getMessageText() != null) {
                    messageEncontrado.get().setMessageText(message.getMessageText());
                }

                return messageRepository.save(messageEncontrado.get());
            }
        }
        return message;
    }
    public boolean deleteMessage(int messageId){
        Boolean resultado = getMessage(messageId).map(messagePorEliminar ->{
            messageRepository.delete(messagePorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
}