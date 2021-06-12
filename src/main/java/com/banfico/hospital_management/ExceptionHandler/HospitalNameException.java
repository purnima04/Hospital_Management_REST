package com.banfico.hospital_management.ExceptionHandler;

public class HospitalNameException extends RuntimeException{
    public HospitalNameException(int hospital_id) {
        super(String.format("Hospital with Id %d not found", hospital_id));
    }
    public HospitalNameException(String message){
        super(message);
    }
}
