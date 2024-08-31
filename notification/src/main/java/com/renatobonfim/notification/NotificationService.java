package com.renatobonfim.notification;

import com.renatobonfim.clients.notification.NotificationRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendNotification( NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder()
                        .toCustomerEmail(notificationRequest.toCustomerName() )
                        .toCustomerId(notificationRequest.toCustomerId())
                        .sender("constant_sender")
                        .message(notificationRequest.message() )
                        .sentAt(LocalDateTime.now() )
                        .build()
        );
    }
}
