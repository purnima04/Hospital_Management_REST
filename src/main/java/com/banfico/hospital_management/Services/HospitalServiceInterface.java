package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Entity.HospitalEntity;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface HospitalServiceInterface{
    /*public List<HospitalEntity> getHospitals() throws Exception;
    public HospitalEntity getHospital(int hospital_Id)throws Exception;
    public HospitalEntity addHospital(HospitalEntity hospitalEntity) throws Exception;
    public HospitalEntity updateHospital(HospitalEntity hospitalEntity) throws Exception;
    public HospitalEntity deleteHospital(int hospital_Id) throws Exception;
     */

    public HospitalEntity findById(int hospital_Id);
    public HospitalEntity save(HospitalEntity hospitalEntity);
    public List<HospitalEntity> findAll();
    public HospitalEntity update(int hospital_Id, HospitalEntity hospitalEntity);
    public String deleteHospital(int hospital_Id);
}