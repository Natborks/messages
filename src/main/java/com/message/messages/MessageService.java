package com.message.messages;

import com.message.messages.log.Log;
import com.message.messages.log.LogRepository;

public class MessageService implements IMessageService{


    private final LogRepository logRepository;
    public MessageService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public String alterMessage(String message) {

        String altered = message + " ... sent from message service";
        Log log = new Log();
        log.setMessage(altered);
        logRepository.save(log);

        return altered;
    }
}
