package com.banfico.hospital_management.Controller;

import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ResponseEntity<DoctorEntity> getDoctors() {
        try {
            return new ResponseEntity(doctorService.getDoctors(), HttpStatus.CREATED);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/doctors/{doctors_Id}", method = RequestMethod.GET)
    public ResponseEntity<DoctorEntity> getDoctor(@Valid @PathVariable Long doctor_Id){
        try {
            return new ResponseEntity<>(doctorService.getDoctor(doctor_Id), HttpStatus.FOUND);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/doctors", method = RequestMethod.POST)
    public ResponseEntity<DoctorEntity> addDoctor(@RequestBody DoctorEntity doctorEntity){
        try {
            return new ResponseEntity<>(doctorService.addDoctor(doctorEntity), HttpStatus.CREATED);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/doctors", method = RequestMethod.PUT)
    public ResponseEntity<DoctorEntity> updateDoctor(@Valid @RequestBody DoctorEntity doctorEntity){
        try {
            return new ResponseEntity<>(doctorService.updateDoctor(doctorEntity), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }


    }
    @RequestMapping(value = "doctors/{doctor_Id}", method = RequestMethod.DELETE)public ResponseEntity<HttpStatus> deleteHospital(@PathVariable String doctor_Id){
        try {
            this.deleteHospital(doctor_Id);
            return new ResponseEntity<>(HttpStatus.GONE);

        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
