package com.banfico.hospital_management.Controller;

import com.banfico.hospital_management.Model.Hospital;
import com.banfico.hospital_management.Services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ResponseEntity<Hospital> getHospitals() {
        try {
            //return this.hospitalService.getHospitals();
            return new ResponseEntity<>(hospitalService.getHospital(), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/details/{hospital_Id}", method = RequestMethod.GET)
    public ResponseEntity<Hospital> getHospital(@PathVariable String hospital_Id){
        try {
            //return this.hospitalService.getHospital(hospital_Id);
            return new ResponseEntity<>(hospitalService.getHospital(hospital_Id), HttpStatus.FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital){
        try {
            //return this.addHospital(hospital);
            return new ResponseEntity<>(hospitalService.addHospital(hospital), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/details", method = RequestMethod.PUT)
    public ResponseEntity<Hospital> updateHospital(@RequestBody Hospital hospital){
        try {
            //return this.updateHospital(hospital);
            return new ResponseEntity<>(hospitalService.updateHospital(hospital), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }


    }
    @RequestMapping(value = "details/{hospital_Id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteHospital(@PathVariable String hospital_Id){
        try {
            this.deleteHospital(hospital_Id);
            return new ResponseEntity<>(HttpStatus.GONE);

        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
