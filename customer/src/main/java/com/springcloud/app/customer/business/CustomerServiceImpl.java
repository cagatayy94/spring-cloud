package com.springcloud.app.customer.business;

import com.springcloud.app.customer.dataAccess.CustomerRepository;
import com.springcloud.app.customer.entities.Customer;
import com.springcloud.app.customer.entities.dtos.CustomerRegisterDTO;
import com.springcloud.clients.fraud.FraudCheckResponse;
import com.springcloud.clients.fraud.FraudClient;
import com.springcloud.clients.notification.NotificationClient;
import com.springcloud.clients.notification.NotificationResponse;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        FraudClient fraudClient,
        NotificationClient notificationClient
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

        NotificationResponse notificationResponse;

        // todo: make this async
        do {
            notificationResponse = notificationClient.sendNotification(customer.getId());
        }while (!notificationResponse.isSuccess());

    }
}
