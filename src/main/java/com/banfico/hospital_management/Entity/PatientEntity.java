package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Patient;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PATIENT_TABLE")
public class PatientEntity extends Patient {
    @Column(name = "PATIENT_ID")
    private String patient_Id;
    @Column(name = "PATIENT_NAME")
    private String patient_name;
    @Column(name = "PATIENT_CONTACT")
    private long patient_contactNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patientEntity", fetch = FetchType.LAZY, targetEntity = PatientEntity.class)
    private AboutPatientEntity aboutPatientEntity;
    @Column(name = "PATIENT_IN_TIME")
    private Timestamp patient_In;
    @Column(name = "PATIENT_OUT_TIME")
    private Timestamp patient_Out;
    @ManyToMany(mappedBy = "patientEntity")
    private Set<DoctorEntity> doctorEntity=new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patientEntity", fetch = FetchType.LAZY, targetEntity = PatientEntity.class)
    private BillingEntity billingEntity;
}
