package com.banfico.hospital_management.ExceptionHandler.Hospital;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HospitalNotFoundException extends RuntimeException{
    public HospitalNotFoundException(int hospital_id) {
        super(String.format("Hospital with Id %d not found", hospital_id));
    }
    public HospitalNotFoundException(String message){
        super(message);
    }
}
