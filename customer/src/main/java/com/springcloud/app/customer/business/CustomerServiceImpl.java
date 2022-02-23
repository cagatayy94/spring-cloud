package com.springcloud.app.customer.business;

import com.springcloud.app.customer.dataAccess.CustomerRepository;
import com.springcloud.app.customer.entities.Customer;
import com.springcloud.app.customer.entities.dtos.CustomerRegisterDTO;
import com.springcloud.clients.fraud.FraudCheckResponse;
import com.springcloud.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        RestTemplate restTemplate,
        FraudClient fraudClient
) implements CustomerService {

    @Override
    public void register(CustomerRegisterDTO registerDTO) {
        Customer customer = new Customer();
        customer.setEmail(registerDTO.getEmail());
        customer.setFirstName(registerDTO.getName());
        customer.setLastname(registerDTO.getLastname());
        customerRepository.save(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()){
            throw  new IllegalStateException("fraudster");
        }
    }
}
