package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.DoctorRepository;
import com.banfico.hospital_management.Dao.HospitalRepository;
import com.banfico.hospital_management.Dao.HospitalResourcesRepository;
import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.ExceptionHandler.HospitalNotFoundException;
import com.banfico.hospital_management.ExceptionHandler.NoDataFoundException;
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
    private HospitalResourcesRepository hospitalResourcesRepository;
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

    /*@Override
    public HospitalEntity findByName(String hospital_name) {
        return hospitalRepository.findByName(hospital_name);
    }

     */
}