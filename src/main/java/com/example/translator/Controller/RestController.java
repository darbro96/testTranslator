package com.example.translator.Controller;

import com.example.translator.Entity.Message;
import com.example.translator.Service.MessageService;
import com.example.translator.enums.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/all")
    public List<Message> getAll() {
        return messageService.findAll();
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable("id") long id) {
        messageService.deleteOne(id);
    }

    @DeleteMapping("/del/all")
    public void clear() {
        messageService.deleteAll();
    }

    @PostMapping("/send/type={type}/{message}")
    public void putMessage(@PathVariable("message") String message, @PathVariable("type") String type) {
        messageService.addMessage(message, "127.0.0.1", MessageType.valueOf(type));
    }

}
