package com.message.messages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    private final IMessageService messageService;

    public MessageController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("index")
    public MessageResponse sendMessage(MessageRequest message) {
        String alteredMessage = messageService.alterMessage(message.getMessage());

        MessageResponse response = new MessageResponse();

        response.setMessage(alteredMessage);

        return  response;
    }
}
