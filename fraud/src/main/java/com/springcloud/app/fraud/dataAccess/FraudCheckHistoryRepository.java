package com.springcloud.app.fraud.dataAccess;

import com.springcloud.app.fraud.entities.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
