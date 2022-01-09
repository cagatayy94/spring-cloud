package com.springcloud.app.fraud.controller;

import com.springcloud.app.fraud.business.FraudCheckService;
import com.springcloud.app.fraud.entities.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public record FraudController(FraudCheckService fraudCheckService) {

    @GetMapping(
            path = "{customerId}"
    )
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        Boolean fraud =  fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check req for customer {}", customerId );
        return new FraudCheckResponse(fraud);
    }

}
