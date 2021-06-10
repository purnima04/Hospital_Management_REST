package com.banfico.hospital_management.Controller;

import com.banfico.hospital_management.Entity.BillingEntity;
import com.banfico.hospital_management.Services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class BillingController {
    @Autowired
    private BillingService billingService;

    @RequestMapping(value = "/billing", method = RequestMethod.GET)
    public ResponseEntity<BillingEntity> getBills() {
        try {
            return new ResponseEntity(billingService.getBills(), HttpStatus.CREATED);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/billing/{bill_Id}", method = RequestMethod.GET)
    public ResponseEntity<BillingEntity> getBill(@Valid @PathVariable Long bill_Id){
        try {
            return new ResponseEntity<>(billingService.getBill(bill_Id), HttpStatus.FOUND);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/billing", method = RequestMethod.POST)
    public ResponseEntity<BillingEntity> addBill(@RequestBody BillingEntity billingEntity){
        try {
            return new ResponseEntity<>(billingService.addBill(billingEntity), HttpStatus.CREATED);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/billing", method = RequestMethod.PUT)
    public ResponseEntity<BillingEntity> updateBill(@Valid @RequestBody BillingEntity billingEntity){
        try {
            return new ResponseEntity<>(billingService.updateBill(billingEntity), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }


    }
    @RequestMapping(value = "billing/{bill_Id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteBill(@PathVariable Long bill_Id){
        try {
            this.deleteBill(bill_Id);
            return new ResponseEntity<>(HttpStatus.GONE);

        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
