package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Entity.HospitalEntity;

import java.util.List;

public interface HospitalServiceInterface{
    public List<HospitalEntity> getHospitals();
    public HospitalEntity getHospital(String hospital_Id);
    public HospitalEntity addHospital(HospitalEntity hospitalEntity);
    public HospitalEntity updateHospital(HospitalEntity hospitalEntity);
    public void deleteHospital(String hospital_Id);
}
