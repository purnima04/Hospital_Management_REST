package com.banfico.hospital_management.ExceptionHandler.Doctor;

public class NoDoctorDataFoundException extends RuntimeException{
    public NoDoctorDataFoundException() {
        super(String.format("No doctor data found"));
    }
}
