package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.PatientEntity;

import java.util.List;

public interface PatientServiceInterface {
    public List<PatientEntity> getPatients();
    public PatientEntity getPatient(Long patient_Id);
    public PatientEntity addPatient(PatientEntity patientEntity);
    public PatientEntity updatePatient(PatientEntity patientEntity);
    public void deletePatient(Long patient_Id);
}
