package com.banfico.hospital_management.ExceptionHandler.Patient;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(int patient_Id) {
        super(String.format("Patient with Id %d not found", patient_Id));
    }
    public PatientNotFoundException(String message){
        super(message);
    }

}
