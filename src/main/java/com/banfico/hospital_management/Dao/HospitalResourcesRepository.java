package com.banfico.hospital_management.Dao;

import com.banfico.hospital_management.Entity.HospitalResourcesEntity;
import com.banfico.hospital_management.Model.HospitalResources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalResourcesRepository extends JpaRepository<HospitalResourcesEntity, String> {
}
