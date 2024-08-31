package com.renatobonfim.customer;

import com.renatobonfim.clients.fraud.FraudCheckResponse;
import com.renatobonfim.clients.fraud.FraudClient;
import com.renatobonfim.clients.notification.NotificationClient;
import com.renatobonfim.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        // todo: check if email is valid
        // todo: check if firstName is valid
        // todo: check fi lastName is valid
        customerRepository.saveAndFlush(customer);


        com.renatobonfim.clients.fraud.FraudCheckResponse fraudCheckResponse2 = fraudClient.isFrausdster( customer.getId() );

        if (fraudCheckResponse2.isFraudster() ) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getFirstName(),
                String.format("Hi %s %s, welcome ... ", customer.getFirstName(),customer.getLastName() ));

        notificationClient.sendNotification( notificationRequest );
    }

}
