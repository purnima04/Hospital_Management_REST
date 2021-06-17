
package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.DoctorRepository;
import com.banfico.hospital_management.Dao.HospitalRepository;
import com.banfico.hospital_management.Dao.PatientRepository;
import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.Entity.PatientEntity;
import com.banfico.hospital_management.ExceptionHandler.Doctor.DoctorIDException;
import com.banfico.hospital_management.ExceptionHandler.Doctor.DoctorNotFoundException;
import com.banfico.hospital_management.ExceptionHandler.Doctor.NoDoctorDataFoundException;
import com.banfico.hospital_management.ExceptionHandler.Hospital.HospitalNotFoundException;
import com.banfico.hospital_management.ExceptionHandler.Hospital.NoHospitalDataFoundException;
import com.banfico.hospital_management.ExceptionHandler.Patient.NoPatientDataFoundException;
import com.banfico.hospital_management.ExceptionHandler.Patient.PatientIDException;
import com.banfico.hospital_management.ExceptionHandler.Patient.PatientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService implements HospitalServiceInterface{
    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    //-----------------------------------------------HOSPITAL-------------------------------------------------------

    @Override
    public List<HospitalEntity> findAll() {
        List<HospitalEntity> hospitals = (List<HospitalEntity>) hospitalRepository.findAll();
        if (hospitals.isEmpty()) {
            throw new NoHospitalDataFoundException();
        }
        return hospitals;
    }
    public HospitalEntity update(int hospital_Id, @Valid HospitalEntity hospitalEntity) {
        Optional<HospitalEntity> p = hospitalRepository.findById(hospital_Id);
        if (p.isPresent()) {
            hospitalEntity.setHospital_Id(hospital_Id);
            hospitalRepository.save(hospitalEntity);
            return hospitalEntity;
        } else {
            throw new HospitalNotFoundException("Hospital does not exist with this id " + hospital_Id);
        }
    }
    @Override
    public HospitalEntity findById(int hospital_Id) {
        return hospitalRepository.findById(hospital_Id).orElseThrow(()->new HospitalNotFoundException(hospital_Id));
    }
    @Override
    public HospitalEntity addHospital(HospitalEntity hospitalEntity){
        hospitalRepository.save(hospitalEntity);
        return hospitalEntity;
    }
    @Override
    public String deleteHospital(int hospital_Id){
        //HospitalEntity hospitals = hospitalRepository.findById(hospital_Id);
        hospitalRepository.deleteById(hospital_Id);
        return "Successful deletion";
    }

    //------------------------------------------------DOCTOR-------------------------------------------------------

    @Override
    public List<DoctorEntity> findAllDoctor() {
        List<DoctorEntity> doctorEntityList = (List<DoctorEntity>) doctorRepository.findAll();
        if (doctorEntityList.isEmpty()) {
            throw new NoDoctorDataFoundException();
        }
        return doctorEntityList;
    }
    @Override
    public DoctorEntity findDoctorById(int doctor_Id) {
        return doctorRepository.findById(doctor_Id).orElseThrow(()->new DoctorIDException(doctor_Id));
    }
    public DoctorEntity updateDoctor(int doctor_Id, @Valid DoctorEntity doctorEntity) {
        Optional<DoctorEntity> p = doctorRepository.findById(doctor_Id);
        if (p.isPresent()) {
            doctorEntity.setDoctor_Id(doctor_Id);
            doctorRepository.save(doctorEntity);
            return doctorEntity;
        } else {
            throw new DoctorNotFoundException(doctor_Id);
        }
    }
    @Override
    public DoctorEntity addDoctor(DoctorEntity doctorEntity){
        doctorRepository.save(doctorEntity);
        return doctorEntity;
    }
    @Override
    public String deleteDoctor(int doctor_Id){
        doctorRepository.deleteById(doctor_Id);
        return "Successful deletion";
    }

    //------------------------------------------------PATIENT-------------------------------------------------------

    @Override
    public List<PatientEntity> findAllPatient() {
        List<PatientEntity> patientEntityList = (List<PatientEntity>) patientRepository.findAll();
        if (patientEntityList.isEmpty()) {
            throw new NoPatientDataFoundException();
        }
        return patientEntityList;
    }

    @Override
    public PatientEntity findPatientById(int patient_Id) {
        return patientRepository.findById(patient_Id).orElseThrow(()->new PatientIDException(patient_Id));
    }

    @Override
    public PatientEntity updatePatient(int patient_Id, PatientEntity patientEntity) {
        Optional<PatientEntity> p = patientRepository.findById(patient_Id);
        if (p.isPresent()) {
            patientEntity.setPatient_Id(patient_Id);
            patientRepository.save(patientEntity);
            return patientEntity;
        } else {
            throw new PatientNotFoundException("Patient does not exist with this id " + patient_Id);
        }
    }
    @Override
    public PatientEntity addPatient(PatientEntity patientEntity) {
        patientRepository.save(patientEntity);
        return patientEntity;
    }

    @Override
    public String deletePatient(int patient_Id) {
        patientRepository.deleteById(patient_Id);
        return "Successful deletion";
    }
}