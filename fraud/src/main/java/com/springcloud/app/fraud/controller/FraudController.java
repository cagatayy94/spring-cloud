package com.springcloud.app.fraud.controller;

import com.springcloud.app.fraud.business.FraudCheckService;
import com.springcloud.app.fraud.entities.FraudCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckService) {

    @PostMapping(
            path = "{customerId}"
    )
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        Boolean fraud =  fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraud);
    }

}
