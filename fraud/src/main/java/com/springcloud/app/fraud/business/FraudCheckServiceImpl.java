package com.springcloud.app.fraud.business;

import com.springcloud.app.fraud.dataAccess.FraudCheckHistoryRepository;
import com.springcloud.app.fraud.entities.FraudCheckHistory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckServiceImpl(FraudCheckHistoryRepository fraudCheckHistoryRepository) implements FraudCheckService {

    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
