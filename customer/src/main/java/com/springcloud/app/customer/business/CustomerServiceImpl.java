package com.springcloud.app.customer.business;

import com.springcloud.app.customer.dataAccess.CustomerRepository;
import com.springcloud.app.customer.entities.Customer;
import com.springcloud.app.customer.entities.dtos.CustomerRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository) implements CustomerService {

    @Override
    public void register(CustomerRegisterDTO registerDTO) {
        Customer customer = new Customer();
        customer.setEmail(registerDTO.getEmail());
        customer.setFirstName(registerDTO.getName());
        customer.setLastname(registerDTO.getLastname());
        customerRepository.save(customer);
    }
}
