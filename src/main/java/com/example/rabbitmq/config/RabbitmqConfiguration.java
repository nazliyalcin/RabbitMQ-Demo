package com.example.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

    @Value("${sr.rabbit.queue.name}")
    private String queueName;
    @Value("${sr.rabbit.binding.key}")
    private String bindingKey;
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;


    @Bean
    public Queue queue(){
         return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange = new DirectExchange(exchangeName);
        //directExchange.setDelayed(true);
      // return ExchangeBuilder.directExchange(exchangeName).delayed().build();
        return directExchange;
        // return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding route(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(bindingKey);
    }

   @Bean
    public Jackson2JsonMessageConverter producerMessageConverter(){
        return new Jackson2JsonMessageConverter();
   }

   @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
   {
       RabbitTemplate rabbitTemplate = new RabbitTemplate((connectionFactory));
       rabbitTemplate.setMessageConverter(producerMessageConverter());
       return rabbitTemplate;
   }


}
