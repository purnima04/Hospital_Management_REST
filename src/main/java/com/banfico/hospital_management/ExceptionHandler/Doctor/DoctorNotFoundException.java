package com.banfico.hospital_management.ExceptionHandler.Doctor;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(int doctor_Id) {
        super(String.format("Doctor with Id %d not found", doctor_Id));
    }
    public DoctorNotFoundException(String message){
        super(message);
    }
}
