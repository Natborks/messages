package com.message.messages.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> Kafkatemplate;

    public void sendMessage(String topic, String message) {
        Kafkatemplate.send(topic, message);
    }
}
