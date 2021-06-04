package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.AboutPatient;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ABOUT_PATIENT_TABLE")
public class AboutPatientEntity extends AboutPatient {
    @Column(name = "PATIENT_ID")
    private long patient_id;
    @Column(name = "PATIENT_ADDRESS")
    private String patient_address;
    @Column(name = "PATIENT_GENDER")
    private String patient_gender;
    @Column(name = "PATIENT_EMAIL_ID")
    private String patient_emailId;
    @Column(name = "DOB")
    private Date patient_DOB;
    @OneToOne(targetEntity = PatientEntity.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "PATIENT_ID")
    private PatientEntity patientEntity;
}
