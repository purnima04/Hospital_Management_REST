package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
