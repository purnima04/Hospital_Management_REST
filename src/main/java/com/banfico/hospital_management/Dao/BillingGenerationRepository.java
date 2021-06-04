package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Model.BillGeneration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingGenerationRepository extends JpaRepository<BillGeneration, Long> {
}
