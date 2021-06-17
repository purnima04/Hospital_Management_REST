package com.banfico.hospital_management.ExceptionHandler.Patient;

public class PatientIDException extends RuntimeException{
    public PatientIDException(int patient_Id) {
        super("Patient with " + patient_Id + " cannot be found");
    }
}
