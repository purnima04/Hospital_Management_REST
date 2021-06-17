package com.banfico.hospital_management.Controller;

import com.banfico.hospital_management.API_Paths.API_paths;
import com.banfico.hospital_management.Entity.HospitalEntity;
import com.banfico.hospital_management.Services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(API_paths.hospitalPathCtrl.CTRL)
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(value = "/details")
    public List<HospitalEntity> getHospitals() {
        return hospitalService.findAll();
    }

    @GetMapping(value = "/details/{hospital_Id}")
    public HospitalEntity getHospital(@PathVariable int hospital_Id) {
        return hospitalService.findById(hospital_Id);
    }

    @PutMapping(value = "/details/{hospital_Id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HospitalEntity updateHospital(@PathVariable(name = "hospital_Id", required = true) int hospital_Id,
                                         @Valid @RequestBody HospitalEntity hospitalEntity) {
        return hospitalService.update(hospital_Id, hospitalEntity);
    }

    @PatchMapping(value = "/details",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HospitalEntity assignDoctor(@RequestParam(name = "hospital_Id", required = true) int hospital_Id,
                                     @Valid @RequestBody HospitalEntity hospitalEntity) {
        return hospitalService.update(hospital_Id, hospitalEntity);
    }

    @PostMapping(value = "/details")
    public ResponseEntity<HospitalEntity> addHospital(@Valid @RequestBody HospitalEntity hospitalEntity) {
        HospitalEntity hospital=hospitalService.addHospital(hospitalEntity);
        return new ResponseEntity<>(hospital, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/details", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteHospital(@RequestParam int hospital_Id){
        hospitalService.deleteHospital(hospital_Id);
        return ResponseEntity.accepted().body("Deleted hospital information successfully");
    }
}
