package com.banfico.hospital_management.ExceptionHandler.Hospital;

public class HospitalIDException extends RuntimeException{
    public HospitalIDException(int hospital_Id){
        super("Hospital with ID : "+hospital_Id+" cannot be found");
    }
}