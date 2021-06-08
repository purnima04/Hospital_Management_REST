package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<HospitalEntity, String> {
}