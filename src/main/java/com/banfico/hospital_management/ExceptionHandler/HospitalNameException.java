package com.banfico.hospital_management.ExceptionHandler;

public class HospitalNameException extends RuntimeException{
    public HospitalNameException(String hospital_name){
        super("Hospital with "+hospital_name+" cannot be found");
    }
}