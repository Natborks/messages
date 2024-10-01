package com.message.messages;

import com.message.messages.log.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagesApplication.class, args);
	}

	@Autowired
	LogRepository logRepository;

	@Bean
	public MessageService messageService() {
		return new MessageService(logRepository);
	}

}
