package com.example.rabbitmq.producer;

import com.example.rabbitmq.model.Notification;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Jackson2JsonMessageConverter jackson2JsonMessageConverter;
    @PostConstruct
    public void init(){
        Notification notification = new Notification(UUID.randomUUID().toString(),new Date(),Boolean.FALSE,"Rabbit message");
        sendToQueue(notification);
    }


    public void sendToQueue(Notification notification){
        System.out.println("Notification sent ID :" + notification.getId());

        //rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);

        rabbitTemplate.convertAndSend("exchange1","bindingKey1", notification);

    }


}
