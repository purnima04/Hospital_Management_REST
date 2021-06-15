package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {

}