package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.HospitalRepository;
import com.banfico.hospital_management.Entity.HospitalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService implements HospitalServiceInterface{

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<HospitalEntity> getHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public HospitalEntity getHospital(String hospital_Id) {
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
    public void deleteHospital(String hospital_Id) {
        HospitalEntity deletedEntity=hospitalRepository.getOne(hospital_Id);
        hospitalRepository.delete(deletedEntity);
    }
}
