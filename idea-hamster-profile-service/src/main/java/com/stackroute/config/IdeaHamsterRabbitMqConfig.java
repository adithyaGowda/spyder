package com.stackroute.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class IdeaHamsterRabbitMqConfig {

    /* -----------------profile------------------- */
    @Value("${ihProfile.rabbitmq.queue}")
    String profileQueueName;
    @Value("${ihProfile.rabbitmq.exchange}")
    String profileExchange;
    @Value("${ihProfile.rabbitmq.routingkey}")
    String profilRoutingkey;
    @Bean
    Queue queueProfile() {
        return new Queue(profileQueueName, true);
    }
    @Bean
    TopicExchange exchangeProfile() {
        return new TopicExchange(profileExchange);
    }
    @Bean
    Binding bindingProfile(Queue queueProfile, TopicExchange exchangeProfile) {
        return  BindingBuilder.bind(queueProfile).to(exchangeProfile).with(profilRoutingkey);
    }
//    configuration for consuming ide
    @Value("${ideah.rabbitmq.queue}")
    String ideaQueue;
    @Value("${idea.rabbitmq.exchange}")
    String ideaExchange;
    @Value("${idea.rabbitmq.routingkey}")
    String ideaKey;

    @Bean
    Queue queueIdea(){
        return new Queue(ideaQueue,true);
    }
    @Bean
    TopicExchange exchangeIdea(){
        return new TopicExchange(ideaExchange);
    }
    @Bean
    Binding bindingIdea(Queue queueIdea,TopicExchange exchangeIdea){
        return BindingBuilder.bind(queueIdea).to(exchangeIdea).with(ideaKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}