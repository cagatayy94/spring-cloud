package com.springcloud.app.customer.dataAccess;

import com.springcloud.app.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
