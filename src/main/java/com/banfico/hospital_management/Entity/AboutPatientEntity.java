package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.AboutPatient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@Entity
@Table(name = "ABOUT_PATIENT_TABLE")
public class AboutPatientEntity extends AboutPatient {
    //private static final String MY_TIME_ZONE="Asia/Kolkata";
    @Column(name = "PATIENT_ADDRESS")
    private String patient_address;
    @Column(name = "PATIENT_GENDER")
    private String patient_gender;
    @NotNull
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "check your mail id")
    @Column(name = "PATIENT_EMAIL_ID")
    private String patient_emailId;
    @Column(name = "DOB")
    @JsonFormat(pattern = "dd-mm-yyyy")
    @NotEmpty
    private Date patient_DOB;
    @OneToOne
    @PrimaryKeyJoinColumn
    private PatientEntity patientEntity;
}
