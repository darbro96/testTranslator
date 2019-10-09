package com.example.translator.Service;

import com.example.translator.Entity.Message;
import com.example.translator.Repository.MessageRepository;
import com.example.translator.enums.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(String message, String destination, MessageType messageType) {
        Message m = new Message();
        m.setContent(message);
        m.setIpDestination(destination);
        m.setMessageType(messageType);
        messageRepository.save(m);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public void deleteOne(long id) {
        Message message = messageRepository.getOne(id);
        messageRepository.delete(message);
    }

    public void deleteAll()
    {
        messageRepository.deleteAll();
    }

    @PostConstruct
    private void addTestMessage() {
        Message message = new Message();
        message.setContent("Wiadomość testowa [automatycznie wygenerowana]");
        message.setIpDestination("127.0.0.1");
        message.setMessageType(MessageType.MESSAGE);
        messageRepository.save(message);
    }
}
