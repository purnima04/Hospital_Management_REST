package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

}
