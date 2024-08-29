package com.renatobonfim.fraud;

import java.time.LocalDateTime;
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
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(name = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer customerId;

    private Boolean isFraudster;

    private LocalDateTime createdAt;
}
