package com.banfico.hospital_management.ExceptionHandler.Patient;

public class NoPatientDataFoundException extends RuntimeException{
    public NoPatientDataFoundException() {
        super(String.format("No patient data found"));
    }
}
