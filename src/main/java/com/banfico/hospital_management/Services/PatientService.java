package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.PatientRepository;
import com.banfico.hospital_management.Entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientServiceInterface{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<PatientEntity> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public PatientEntity getPatient(Long patient_Id) {
        return patientRepository.getById(patient_Id);
    }

    @Override
    public PatientEntity addPatient(PatientEntity patientEntity) {
        return patientRepository.save(patientEntity);
    }

    @Override
    public PatientEntity updatePatient(PatientEntity patientEntity) {
        return patientRepository.save(patientEntity);
    }

    @Override
    public void deletePatient(Long patient_Id) {
        PatientEntity deletedEntity=patientRepository.getById(patient_Id);
        patientRepository.delete(deletedEntity);
    }
}
