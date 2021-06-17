package com.banfico.hospital_management.ExceptionHandler.Doctor;

public class DoctorIDException extends RuntimeException{
    public DoctorIDException(int doctor_Id) {
        super("Doctor with ID : " + doctor_Id + " cannot be found");
    }
}
