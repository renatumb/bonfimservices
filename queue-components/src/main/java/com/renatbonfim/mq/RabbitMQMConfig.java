package com.renatbonfim.mq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class RabbitMQMConfig {

    private final ConnectionFactory connectionFactory;

    /**
     * USED TO SEND MESSAGES TO THE QUEUE (it will serialize the object into json )
     */
    @Bean
    public AmqpTemplate amqpTemplate() {
        log.info("*** Creating AMQP template");
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter( jsonMessageConverter() );
        return rabbitTemplate;
    }

    /**
     *  USED TO DESERIALIZE A JSON INTO AN OBJECT
     * */
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
        log.info("*** Creating SimpleRabbitListenerContainerFactory");
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter( jsonMessageConverter()  );
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        log.info("*** Creating JSON MessageConverter");
        return new Jackson2JsonMessageConverter();
    }
}
