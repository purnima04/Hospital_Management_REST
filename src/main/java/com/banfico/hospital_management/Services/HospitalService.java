
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
/*
    @Autowired
    private ModelMapper modelMapper;

    //-----------------------------------------------HOSPITAL-------------------------------------------------------
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital findById(int hospital_Id) throws Exception {
        Optional<HospitalEntity> optionalHospitalEntity=hospitalRepository.findById(hospital_Id);
        if (optionalHospitalEntity.isPresent()){
            optionalHospitalEntity.get().getDoctorEntity();
            Hospital hospital=modelMapper.map(optionalHospitalEntity.get(), Hospital.class);
            return hospital;
        }else {
            throw new HospitalNotFoundException("Not found");
        }
    }

    @Override
    public HospitalEntity addHospital(HospitalEntity hospitalEntity) {
        hospitalEntity=hospitalRepository.save(hospitalEntity);
        if (hospitalEntity.getHospital_Id()>-1)
            return hospitalEntity;
        else {
            throw new NoHospitalDataFoundException();
        }
    }

    @Override
    public List<Hospital> findAll() throws Exception {
        try{
            List<HospitalEntity> hospitalEntityList =hospitalRepository.findAll();
            if (hospitalEntityList.size()<1)
                throw new HospitalNotFoundException("List of hospital is Empty");
            Hospital[] hospitals=modelMapper.map(hospitalEntityList, Hospital[].class);
            List<Hospital> hospitalList= Arrays.asList(hospitals);
            hospitalList.forEach(hospital -> {
                hospital.getHospitalResourcesEntity().setResource_Id(hospital.getHospital_Id());
                hospital.getDoctorEntity().forEach(doctorEntity -> {
                    doctorEntity.setDoctor_Id(hospital.getHospital_Id());
                });
            });
            return Arrays.asList(hospitals);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public Hospital update(int hospital_Id, HospitalEntity hospitalEntity) {
        Optional<HospitalEntity> hospitalEntityOptional=hospitalRepository.findById(hospital_Id);
        if (hospitalEntityOptional.isPresent()){
            hospitalEntity.setHospital_Id(hospital_Id);
            hospitalRepository.save(hospitalEntity);
            Hospital hospital=modelMapper.map(hospitalEntityOptional.get(), Hospital.class);
            return hospital;
        }
        else {
            throw new HospitalNotFoundException("Not found");
        }
    }

    @Override
    public String delete(@Valid int hospital_Id) {
        hospitalRepository.deleteById(hospital_Id);
        return "Successful deletion";
    }

    //------------------------------------------------DOCTOR-------------------------------------------------------

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAllDoctor() throws Exception {
        try{
            List<DoctorEntity> doctorEntityList =doctorRepository.findAll();
            if (doctorEntityList.size()<1)
                throw new DoctorNotFoundException("List of doctors is Empty");
           Doctor[] doctors=modelMapper.map(doctorEntityList, Doctor[].class);
            List<Doctor> doctorList= Arrays.asList(doctors);
            doctorList.forEach(doctor -> {
                doctor.getPatientEntity().forEach(patientEntity -> {
                    patientEntity.setPatient_Id(doctor.getDoctor_Id());
                });
                doctor.getHospitalEntity().setHospital_Id(doctor.getDoctor_Id());
            });
            return Arrays.asList(doctors);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

/*
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<HospitalEntity> getAllHospital() {
        return hospitalRepository.findAll();
    }

    @Override
    public HospitalEntity addHospital(HospitalEntity hospitalEntity) {
        return hospitalRepository.save(hospitalEntity);
    }

    @Override
    public HospitalEntity updateHospital(int hospital_Id, HospitalEntity hospitalEntity) {
        HospitalEntity hospitalEntity1 =hospitalRepository.findById(hospital_Id)
                .orElseThrow(() -> new HospitalNotFoundException("Not found"));

        hospitalEntity1.setHospital_Id(hospitalEntity.getHospital_Id());
        hospitalEntity1.setHospital_name(hospitalEntity.getHospital_name());
        hospitalEntity1.setHospital_address(hospitalEntity.getHospital_address());
        hospitalEntity1.setHospital_mailId(hospitalEntity.getHospital_mailId());
        hospitalEntity1.setHospital_emergencyNo(hospitalEntity.getHospital_emergencyNo());
        hospitalEntity1.setHospitalResourcesEntity(hospitalEntity.getHospitalResourcesEntity());
        hospitalEntity1.setHealthCareBranchEntity(hospitalEntity.getHealthCareBranchEntity());
        hospitalEntity1.setDoctorEntity(hospitalEntity.getDoctorEntity());
        return hospitalRepository.save(hospitalEntity);
    }

    @Override
    public void deleteHospital(int hospital_Id) {
        HospitalEntity hospitalEntity = hospitalRepository.findById(hospital_Id)
                .orElseThrow(() -> new NoHospitalDataFoundException());
        hospitalRepository.delete(hospitalEntity);
    }

    @Override
    public HospitalEntity getHospitalById(int hospital_Id) {
        Optional<HospitalEntity> hospitalEntityOptional = hospitalRepository.findById(hospital_Id);
        if(hospitalEntityOptional.isPresent()) {
            return hospitalEntityOptional.get();
        }else {
            throw new HospitalNotFoundException("Not found");
        }
    }
 */

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