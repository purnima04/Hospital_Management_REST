package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.HospitalEntity;

import java.util.List;

public interface DoctorServiceInterface {
    public List<DoctorEntity> getDoctors();
    public DoctorEntity getDoctor(Long doctor_Id);
    public DoctorEntity addDoctor(DoctorEntity doctorEntity);
    public DoctorEntity updateDoctor(DoctorEntity doctorEntity);
    public void deleteDoctor(Long hospital_Id);
}
