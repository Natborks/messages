package com.message.messages;

import com.message.messages.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    private final IMessageService messageService;

    @Autowired
    private MessageProducer messageProducer;

    public MessageController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("index")
    public MessageResponse sendMessage(MessageRequest message) {
        String alteredMessage = messageService.alterMessage(message.getMessage());

        MessageResponse response = new MessageResponse();
        messageProducer.sendMessage("my-topic", alteredMessage);

        response.setMessage(alteredMessage);

        System.out.println("MY TOPIC "+  alteredMessage);

        return  response;
    }
}
