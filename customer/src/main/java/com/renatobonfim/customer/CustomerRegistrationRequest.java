package com.renatobonfim.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
