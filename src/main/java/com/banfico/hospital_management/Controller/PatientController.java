package com.banfico.hospital_management.Controller;

import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.Entity.PatientEntity;
import com.banfico.hospital_management.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class PatientController {
    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ResponseEntity<PatientEntity> getPatients() {
        try {
            return new ResponseEntity(patientService.getPatients(), HttpStatus.CREATED);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/patients/{patient_Id}", method = RequestMethod.GET)
    public ResponseEntity<PatientEntity> getHospital(@Valid @PathVariable Long patient_Id){
        try {
            return new ResponseEntity<>(patientService.getPatient(patient_Id), HttpStatus.FOUND);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public ResponseEntity<PatientEntity> addPatient(@RequestBody PatientEntity patientEntity){
        try {
            return new ResponseEntity<>(patientService.addPatient(patientEntity), HttpStatus.CREATED);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/patients", method = RequestMethod.PUT)
    public ResponseEntity<PatientEntity> updatePatient(@Valid @RequestBody PatientEntity patientEntity){
        try {
            return new ResponseEntity<>(patientService.updatePatient(patientEntity), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }


    }
    @RequestMapping(value = "patients/{patient_Id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable Long patient_Id){
        try {
            this.deletePatient(patient_Id);
            return new ResponseEntity<>(HttpStatus.GONE);

        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
