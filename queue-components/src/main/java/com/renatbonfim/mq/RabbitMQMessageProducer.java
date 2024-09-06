package com.renatbonfim.mq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    /**
     *
     * */
    public void publishMessage(String exchange, String routingKey, Object messagePayload) {
        amqpTemplate.convertAndSend(exchange, routingKey, messagePayload);
    }
}
