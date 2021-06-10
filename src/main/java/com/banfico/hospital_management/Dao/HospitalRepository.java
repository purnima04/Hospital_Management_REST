package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
}