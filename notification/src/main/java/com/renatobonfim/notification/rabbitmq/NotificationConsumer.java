package com.renatobonfim.notification.rabbitmq;

import com.renatobonfim.clients.notification.NotificationRequest;
import com.renatobonfim.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "queue001")
    public void notificationConsumer(NotificationRequest notificationRequest){
        log.info(" -- - - -  - - - - - - ");
        log.info("Notification Consumer Started, data {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
