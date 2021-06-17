package com.banfico.hospital_management.ExceptionHandler.Hospital;

public class NoHospitalDataFoundException extends RuntimeException{
    public NoHospitalDataFoundException() {
        super(String.format("No hospital data found"));
    }
}