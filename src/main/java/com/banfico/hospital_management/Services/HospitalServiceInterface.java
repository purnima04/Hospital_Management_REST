package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.Entity.PatientEntity;

import java.util.List;

public interface HospitalServiceInterface{
/*
//-----------------------------------------------HOSPITAL-------------------------------------------------------

    public Hospital findById(int hospital_Id) throws Exception;
    public HospitalEntity addHospital(HospitalEntity hospitalEntity);
    public List<Hospital> findAll() throws Exception;
    public Hospital update(int hospital_Id, HospitalEntity hospitalEntity);
    public String delete(int hospital_Id);
    //------------------------------------------------DOCTOR-------------------------------------------------------


    public List<Doctor> findAllDoctor() throws Exception;
    */
    //-----------------------------------------------HOSPITAL-------------------------------------------------------

    public HospitalEntity findById(int hospital_Id);
    public HospitalEntity addHospital(HospitalEntity hospitalEntity);
    public List<HospitalEntity> findAll();
    public HospitalEntity update(int hospital_Id, HospitalEntity hospitalEntity);
    public String deleteHospital(int hospital_Id);

    //------------------------------------------------DOCTOR-------------------------------------------------------

    public List<DoctorEntity> findAllDoctor();
    public DoctorEntity findDoctorById(int doctor_Id);
    public DoctorEntity updateDoctor(int doctor_Id, DoctorEntity doctorEntity);
    public String deleteDoctor(int doctor_Id);
    public DoctorEntity addDoctor(DoctorEntity doctorEntity);

    //------------------------------------------------PATIENT-------------------------------------------------------

    public PatientEntity findPatientById(int patient_Id);
    public PatientEntity addPatient(PatientEntity patientEntity);
    public List<PatientEntity> findAllPatient();
    public PatientEntity updatePatient(int patient_Id, PatientEntity patientEntity);
    public String deletePatient(int patient_Id);


    /*
    //-----------------------------------------------HOSPITAL-------------------------------------------------------
    public List<Hospital> findAll() throws Exception;
    public HospitalEntity findById(int hospital_Id);
    public HospitalEntity addHospital(HospitalEntity hospitalEntity);
    public HospitalEntity update(int hospital_Id, HospitalEntity hospitalEntity);
    public String deleteHospital(int hospital_Id);

     */
    /*
    List<HospitalEntity> getAllHospital();
    HospitalEntity addHospital(HospitalEntity hospitalEntity);
    HospitalEntity updateHospital(int hospital_Id, HospitalEntity hospitalEntity);
    void deleteHospital(int hospital_Id);
    HospitalEntity getHospitalById(int hospital_Id);

     */
}
