package com.renatobonfim.fraud;

import com.renatobonfim.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFrausdster(@PathVariable("customerId") Integer customerId) {

        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("check isFrausdster() for: {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
