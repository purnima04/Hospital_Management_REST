package com.banfico.hospital_management.Controller;

import com.banfico.hospital_management.API_Paths.API_paths;
import com.banfico.hospital_management.Entity.PatientEntity;
import com.banfico.hospital_management.Services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(API_paths.patientPathCtrl.CTRL)
public class PatientController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(value = "/detail")
    public List<PatientEntity> getPatients() {
        return hospitalService.findAllPatient();
    }

    @GetMapping(value = "/detail/{patient_Id}")
    public PatientEntity getPatient(@PathVariable int patient_Id) {
        return hospitalService.findPatientById(patient_Id);
    }

    @PostMapping(value = "/detail")
    public ResponseEntity<PatientEntity> addPatient(@Valid @RequestBody PatientEntity patientEntity) {
        PatientEntity patientEntity1= hospitalService.addPatient(patientEntity);
        return new ResponseEntity<>(patientEntity1, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/detail",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientEntity updatePatient(@RequestParam(name = "patient_Id", required = true) int patient_Id,
                                         @Valid @RequestBody PatientEntity patientEntity) {
        return hospitalService.updatePatient(patient_Id, patientEntity);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePatient(@RequestParam int patient_Id){
        hospitalService.deletePatient(patient_Id);
        return ResponseEntity.accepted().body("Deleted patient information successfully");
    }


}
