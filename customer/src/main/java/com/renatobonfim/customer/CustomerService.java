package com.renatobonfim.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

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

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://fraudx/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudster) {
            throw new IllegalStateException("fraudster");
        }
    }

    private record FraudCheckResponse(Boolean isFraudster) {
    }
}
