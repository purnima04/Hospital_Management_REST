package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.DoctorRepository;
import com.banfico.hospital_management.Dao.HospitalRepository;
import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.HospitalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements DoctorServiceInterface{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorEntity> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public DoctorEntity getDoctor(Long doctor_Id) {
        return doctorRepository.getById(doctor_Id);
    }

    @Override
    public DoctorEntity addDoctor(DoctorEntity doctorEntity) {
        return doctorRepository.save(doctorEntity);
    }

    @Override
    public DoctorEntity updateDoctor(DoctorEntity doctorEntity) {
        return doctorRepository.save(doctorEntity);
    }

    @Override
    public void deleteDoctor(Long doctor_Id) {
        DoctorEntity deletedEntity=doctorRepository.getById(doctor_Id);
        doctorRepository.delete(deletedEntity);
    }
}
