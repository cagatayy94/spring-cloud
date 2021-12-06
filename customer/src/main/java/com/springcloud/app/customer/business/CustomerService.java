package com.springcloud.app.customer.business;

import com.springcloud.app.customer.entities.dtos.CustomerRegisterDTO;

public interface CustomerService {
    void register(CustomerRegisterDTO customerRegisterDTO);
}
