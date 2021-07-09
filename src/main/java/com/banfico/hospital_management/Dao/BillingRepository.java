package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingEntity, Integer> {

}
