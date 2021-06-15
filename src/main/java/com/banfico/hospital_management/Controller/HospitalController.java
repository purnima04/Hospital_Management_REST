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
    /*
        @Autowired
        private HospitalService hospitalService;
        @RequestMapping(value = "/details", method = RequestMethod.GET)
        public ResponseEntity<HospitalEntity> getHospitals() {
            try {
                return new ResponseEntity(hospitalService.getHospitals(), HttpStatus.CREATED);
            }catch (Exception exception){
                exception.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        @RequestMapping(value = "/details/{hospital_Id}", method = RequestMethod.GET)
        public ResponseEntity<HospitalEntity> getHospital(@Valid @PathVariable Long hospital_Id) {
            try {
                return new ResponseEntity<>(hospitalService.getHospital(hospital_Id), HttpStatus.FOUND);
            } catch (Exception exception) {
                exception.printStackTrace();
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @RequestMapping(value = "/details", method = RequestMethod.POST)
        public ResponseEntity<HospitalEntity> addHospital(@RequestBody HospitalEntity hospitalEntity){
            try {
                return new ResponseEntity<>(hospitalService.addHospital(hospitalEntity), HttpStatus.CREATED);
            }catch (Exception exception){
                exception.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        @RequestMapping(value = "/details/{hospital_Id}", method = RequestMethod.PUT)
        public ResponseEntity<HospitalEntity> updateHospital(@PathVariable("hospital_Id") Long hospital_Id,
                                                            @Valid @RequestBody HospitalEntity hospitalEntity){
            try {
                hospitalService.updateHospital(hospital_Id, hospitalEntity);
                return new ResponseEntity<>(hospitalService.getHospital(hospital_Id), HttpStatus.OK);
            }catch (Exception exception){
                exception.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        @RequestMapping(value = "details/{hospital_Id}", method = RequestMethod.DELETE)
        public ResponseEntity<HttpStatus> deleteHospital(@PathVariable Long hospital_Id){
            try {
                this.deleteHospital(hospital_Id);
                return new ResponseEntity<>(HttpStatus.GONE);
            }catch (Exception exception){
                exception.printStackTrace();
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
     */
    /*
    @Autowired
    private HospitalService hospitalService;
    @GetMapping("/details")
    public ResponseEntity<Object> getHospitals(){
        try {
            List<HospitalEntity> hospitalEntity = hospitalService.getHospitals();
            return new ResponseEntity<>(hospitalEntity, HttpStatus.FOUND);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/details/{hospital_Id}")
    public ResponseEntity<HospitalEntity> getHospital(@Valid @PathVariable int hospital_Id){
        HospitalEntity hospitalEntity;
        try {
            hospitalEntity = hospitalService.getHospital(hospital_Id);
            return new ResponseEntity<>(hospitalEntity,HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/details")
    public ResponseEntity<HospitalEntity> addHospital(@Valid @RequestBody HospitalEntity hospitalEntity) {
        HospitalEntity hospital=hospitalService.addHospital(hospitalEntity);
        return new ResponseEntity<>(hospital,HttpStatus.CREATED);
    }
    @PutMapping("/details")
    public ResponseEntity<HospitalEntity> updateHospital(@Valid @RequestBody HospitalEntity hospitalEntity){
        HospitalEntity hospitalFound = hospitalService.updateHospital(hospitalEntity);
        return new ResponseEntity<>(hospitalFound,HttpStatus.OK);
    }
    @DeleteMapping("/details")
    public ResponseEntity<HospitalEntity> deleteHospital(@Valid @RequestParam("hospital_Id") int hospital_Id){
        HospitalEntity deletedHospital;
        try {
            deletedHospital = hospitalService.deleteHospital(hospital_Id);
            return new ResponseEntity<>(deletedHospital,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
     */
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
    public HospitalEntity updateHospital(@PathVariable(name = "hospital_Id", required = true) int hospital_Id, @Valid @RequestBody HospitalEntity hospitalEntity) {
        //HospitalEntity hospitalFound = hospitalService.update(hospitalEntity);
        return hospitalService.update(hospital_Id, hospitalEntity);
    }

    @PostMapping("/details")
    public ResponseEntity<HospitalEntity> addHospital(@Valid @RequestBody HospitalEntity hospitalEntity) {
        HospitalEntity hospital=hospitalService.addHospital(hospitalEntity);
        return new ResponseEntity<>(hospital, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/details/{hospital_Id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteHospital(@PathVariable int hospital_Id){
        hospitalService.deleteHospital(hospital_Id);
        return ResponseEntity.accepted().body("Successful deletion");
    }
}