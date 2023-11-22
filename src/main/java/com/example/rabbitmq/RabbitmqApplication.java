package com.example.rabbitmq;

import com.example.rabbitmq.model.Notification;
import com.example.rabbitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class RabbitmqApplication {


	public static void main(String[] args) {

		SpringApplication.run(RabbitmqApplication.class, args);

	}

}
