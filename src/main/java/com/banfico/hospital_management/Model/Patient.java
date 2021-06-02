package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Patient {
    @Id
    @Column(name = "PATIENT_ID")
    private String patient_Id;
    @Column(name = "PATIENT_NAME")
    private String patient_name;
    @Column(name = "PATIENT_CONTACT")
    private long patient_contactNumber;
    @Column(name = "PERSONAL_INFO")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
    private About_patient about_patient;
    @Column(name = "PATIENT_IN_TIME")
    private Timestamp patient_In;
    @Column(name = "PATIENT_OUT_TIME")
    private Timestamp patient_Out;
}
