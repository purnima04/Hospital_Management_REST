package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Doctor {
    @Id
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
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Hospital.class)
    @JsonIgnore
    @JoinColumn(name = "Hospital_Id")
    private Hospital hospital;
}
