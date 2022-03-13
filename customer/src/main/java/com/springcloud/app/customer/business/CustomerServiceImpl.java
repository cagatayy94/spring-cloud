package com.springcloud.app.customer.business;

import com.springcloud.app.amqp.RabbitMqMessageProducer;
import com.springcloud.app.customer.dataAccess.CustomerRepository;
import com.springcloud.app.customer.entities.Customer;
import com.springcloud.app.customer.entities.dtos.CustomerRegisterDTO;
import com.springcloud.app.clients.fraud.FraudCheckResponse;
import com.springcloud.app.clients.fraud.FraudClient;
import com.springcloud.app.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        FraudClient fraudClient,
        RabbitMqMessageProducer rabbitMqMessageProducer
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

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getFirstName(),
                "Merhaba "+customer.getFirstName()+"hosgeldin"
        );

        rabbitMqMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");
    }
}
