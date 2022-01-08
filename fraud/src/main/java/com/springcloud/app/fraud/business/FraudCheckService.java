package com.springcloud.app.fraud.business;

public interface FraudCheckService {
    public boolean isFraudulentCustomer(Integer customerId);
}
