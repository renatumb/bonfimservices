package com.renatobonfim.customer;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_id_sequence")
    private Long id;

    String firstName;
    String lastName;
    String email;
}
