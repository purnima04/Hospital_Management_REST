package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.HealthCareBranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCareBranchRepository extends JpaRepository<HealthCareBranchEntity, String> {
}
