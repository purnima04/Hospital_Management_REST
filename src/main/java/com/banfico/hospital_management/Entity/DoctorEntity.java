package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Doctor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "DOCTOR_TABLE")
public class DoctorEntity extends Doctor {
    @Column(name = "DOCTOR_NAME")
    private String doctor_name;
    @Column(name = "DOCTOR_DESIGNATION")
    private String doctor_designation;
    @Column(name = "DEGREE")
    private String doctor_degree;
    @Column(name = "DOCTOR_ADDRESS")
    private String doctor_address;
    @Column(name = "DOCTOR_MAIL_ID")
    private String doctor_emailId;
    @Column(name = "DOCTOR_CONTACT_NO")
    private String doctor_contactNo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Hospital_Id")
    private HospitalEntity hospitalEntity;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Treatment",
            joinColumns = {@JoinColumn(name = "doctor_Id")},
            inverseJoinColumns = {@JoinColumn(name = "patient_Id")})
   Set<PatientEntity> patientEntity=new HashSet<PatientEntity>();
}
