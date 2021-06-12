package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Doctor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "doctor_Id"
)
@Table(name = "DOCTOR_TABLE")
@JsonPropertyOrder({"hospital_Id",
        "hospital_name",
        "hospital_address",
        "hospital_emergencyNo",
        "hospital_mailId",
        "healthCareBranchEntity",
        "hospitalResourcesEntity"})
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
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private HospitalEntity hospitalEntity;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Treatment",
            joinColumns = {@JoinColumn(name = "doctor_Id")},
            inverseJoinColumns = {@JoinColumn(name = "patient_Id")})
    //@ManyToMany(targetEntity = PatientEntity.class, mappedBy = "doctorEntity", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<PatientEntity> patientEntity;
}