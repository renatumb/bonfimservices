package com.renatobonfim.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    String firstName;
    String lastName;
    String email;
}
