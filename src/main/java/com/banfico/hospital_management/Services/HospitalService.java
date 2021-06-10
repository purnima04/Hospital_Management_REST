package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.DoctorRepository;
import com.banfico.hospital_management.Dao.HospitalRepository;
import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.HospitalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.ServiceLoader;

@Service
public class HospitalService implements HospitalServiceInterface{

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
    public HospitalEntity updateHospital(HospitalEntity hospitalEntity) {
        return hospitalRepository.save(hospitalEntity);
    }

    @Override
    public void deleteHospital(Long hospital_Id) {
        HospitalEntity deletedEntity=hospitalRepository.getById(hospital_Id);
        hospitalRepository.delete(deletedEntity);
    }
    public List<DoctorEntity> getDoctors() {
        return doctorRepository.findAll();
    }
}
