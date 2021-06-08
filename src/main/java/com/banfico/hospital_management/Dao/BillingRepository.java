package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.BillingEntity;
import com.banfico.hospital_management.Model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<BillingEntity, Long> {
}
