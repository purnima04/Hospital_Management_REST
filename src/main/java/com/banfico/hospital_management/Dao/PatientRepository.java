package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
