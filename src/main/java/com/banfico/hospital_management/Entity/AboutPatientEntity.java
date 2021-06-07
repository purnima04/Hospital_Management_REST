package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.AboutPatient;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ABOUT_PATIENT_TABLE")
public class AboutPatientEntity extends AboutPatient {
    private static final String MY_TIME_ZONE="Asia/Kolkata";
    @NotNull
    @Column(name = "PATIENT_ID")
    private long patient_id;
    @Column(name = "PATIENT_ADDRESS")
    private String patient_address;
    @Column(name = "PATIENT_GENDER")
    private String patient_gender;
    @NotNull
    @Column(name = "PATIENT_EMAIL_ID")
    private String patient_emailId;
    @Column(name = "DOB")
    @JsonFormat(pattern = "dd-mm-yyyy", timezone = MY_TIME_ZONE)
    @NotEmpty
    private Date patient_DOB;
    @OneToOne(targetEntity = PatientEntity.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "PATIENT_ID")
    private PatientEntity patientEntity;
}
