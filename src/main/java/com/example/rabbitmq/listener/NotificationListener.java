package com.example.rabbitmq.listener;

import com.example.rabbitmq.model.Notification;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

@Service
public class NotificationListener  {


    @RabbitListener(queues = "queue1")
    public void listenMessage(Message message) throws InterruptedException {
        Thread.sleep(10000); // Thread sleep because --> See the message in queue (RabbitMQ GUI) before processed
        System.out.println("Message received after 5 sec...");
        System.out.println(message.getMessageProperties());

        try {
            String messRegister = new String(message.getBody(), "UTF-8");
            System.out.println(messRegister);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


    }
}
