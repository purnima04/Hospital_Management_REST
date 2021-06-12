package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.HealthCareBranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCareBranchRepository extends JpaRepository<HealthCareBranchEntity, Integer> {
}
