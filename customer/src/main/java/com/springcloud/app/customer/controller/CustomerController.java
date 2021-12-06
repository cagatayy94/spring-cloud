package com.springcloud.app.customer.controller;

import com.springcloud.app.customer.business.CustomerService;
import com.springcloud.app.customer.entities.dtos.CustomerRegisterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping()
    public void registerCustomer(@RequestBody CustomerRegisterDTO registerDTO){
        log.info("new customer registration {}", registerDTO);
        // todo: check if email valid and not taken
        customerService.register(registerDTO);
    }

}
