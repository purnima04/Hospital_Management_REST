package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Doctor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DOCTOR_TABLE")
public class DoctorEntity extends Doctor {
    @Column(name = "DOCTOR_ID")
    private String doctor_Id;
    @Column(name = "DOCTOR_NAME")
    private String doctor_name;
    @Column(name = "DOCTOR_DESIGNATION")
    private String doctor_designation;
    @Column(name = "DEGREE")
    private String doctor_degree;
    @Column(name = "DOCTOR_ADDRESS")
    private String doctor_address;
    @Column(name = "DOCTER_MAIL_ID")
    private String doctor_emailId;
    @Column(name = "DOCTOR_CONTACT_NO")
    private long doctor_contactNo;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = HospitalEntity.class)
    @JoinColumn(name = "Hospital_Id")
    private HospitalEntity hospitalEntity;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Treatment",
            joinColumns = {@JoinColumn(name = "DOCTOR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PATIENT_ID")})
    private Set<PatientEntity> patientEntity=new HashSet<>();
}
