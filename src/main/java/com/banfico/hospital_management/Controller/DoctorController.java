package com.banfico.hospital_management.Controller;

import com.banfico.hospital_management.API_Paths.API_paths;
import com.banfico.hospital_management.Entity.DoctorEntity;
import com.banfico.hospital_management.Services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(API_paths.DoctorPathCtrl.CTRL)
public class DoctorController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(value = "/detail")
    public List<DoctorEntity> getDoctors() {
        return hospitalService.findAllDoctor();
    }

    @GetMapping(value = "/detail/{doctor_Id}")
    public DoctorEntity getDoctor(@PathVariable int doctor_Id) {
        return hospitalService.findDoctorById(doctor_Id);
    }

    @PostMapping(value = "/detail")
    public ResponseEntity<DoctorEntity> addDoctor(@Valid @RequestBody DoctorEntity doctorEntity) {
        DoctorEntity doctorEntity1=hospitalService.addDoctor(doctorEntity);
        return new ResponseEntity<>(doctorEntity1, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/detail",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DoctorEntity updateDoctor(@RequestParam(name = "doctor_Id", required = true) int doctor_Id,
                                     @Valid @RequestBody DoctorEntity doctorEntity) {
        return hospitalService.updateDoctor(doctor_Id, doctorEntity);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDoctor(@RequestParam int doctor_Id){
        hospitalService.deleteDoctor(doctor_Id);
        return ResponseEntity.accepted().body("Deleted doctor information successfully");
    }
}
