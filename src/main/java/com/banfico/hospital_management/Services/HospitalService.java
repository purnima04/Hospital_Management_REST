package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.DoctorRepository;
import com.banfico.hospital_management.Dao.HospitalRepository;
import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.ExceptionHandler.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.banfico.hospital_management.ExceptionHandler.HospitalNotFoundException;

import javax.validation.Valid;

@Service
public class HospitalService implements HospitalServiceInterface{
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<HospitalEntity> findAll() {
        List<HospitalEntity> hospitals = (List<HospitalEntity>) hospitalRepository.findAll();
        if (hospitals.isEmpty()) {
            throw new NoDataFoundException();
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
    public HospitalEntity save(HospitalEntity hospitalEntity) {
        return hospitalRepository.save(hospitalEntity);
    }
    @Override
    public String deleteHospital(int hospital_Id){
        Optional hospitals = hospitalRepository.findById(hospital_Id);
        if (hospitals.isEmpty()) {
            throw new NoDataFoundException();
        }else {
            hospitalRepository.deleteById(hospital_Id);
            return ("Hospital got deleted");
        }
    }
/*
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<HospitalEntity> getHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public HospitalEntity getHospital(Long hospital_Id) {
        return hospitalRepository.getById(hospital_Id);
    }

    @Override
    public HospitalEntity addHospital(HospitalEntity hospitalEntity) {
        return hospitalRepository.save(hospitalEntity);
    }

    @Override
    public void updateHospital(Long hospital_Id, HospitalEntity hospitalEntity) {
        HospitalEntity toUpdate=hospitalRepository.findById(hospital_Id).get();
        hospitalRepository.save(toUpdate);
    }

    @Override
    public void deleteHospital(Long hospital_Id) {
        HospitalEntity deletedEntity=hospitalRepository.getById(hospital_Id);
        hospitalRepository.delete(deletedEntity);
    }
    public List<DoctorEntity> getDoctors() {
        return doctorRepository.findAll();
    }

 */
    /*
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<HospitalEntity> getHospitals(){
        return hospitalRepository.findAll();
    }

    @Override
    public HospitalEntity getHospital(int hospital_Id){
        return hospitalRepository.findById(hospital_Id);
    }

    @Override
    public HospitalEntity addHospital(HospitalEntity hospitalEntity) {
        hospitalRepository.save(hospitalEntity);
        return hospitalEntity;
    }

    @Override
    public HospitalEntity updateHospital(HospitalEntity hospitalEntity) {
        hospitalRepository.save(hospitalEntity);
        return hospitalEntity;
    }

    @Override
    public HospitalEntity deleteHospital(int hospital_Id){
        HospitalEntity deletedHospital = hospitalRepository.getById(hospital_Id);
        hospitalRepository.delete(deletedHospital);
        return deletedHospital;
    }

     */
}
