package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Hospital;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
@Data
@Entity
@Table(name = "HOSPITAL_TABLE")
@JsonPropertyOrder({"hospital_Id",
        "hospital_name",
        "hospital_address",
        "hospital_emergencyNo",
        "hospital_mailId",
        "healthCareBranchEntity",
        "hospitalResourcesEntity"})
public class HospitalEntity extends Hospital {

    @Column(name ="HOSPITAL_NAME", nullable = false)
    private String hospital_name;

    @Column(name = "HOSPITAL_ADDRESS")
    private String hospital_address;

    @Column(name = "EMERGENCY_NO")
    private int hospital_emergencyNo;

    @Column(name = "HOSPITAL_MAIL_ID")
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "check your mail id")
    private String hospital_mailId;

    @JsonManagedReference
    @OneToOne(targetEntity = HospitalResourcesEntity.class, mappedBy = "hospitalEntity", cascade = CascadeType.ALL)
    private HospitalResourcesEntity hospitalResourcesEntity;

    @JsonManagedReference
    @OneToOne(targetEntity = HealthCareBranchEntity.class, mappedBy = "hospitalEntity", cascade = CascadeType.ALL)
    private HealthCareBranchEntity healthCareBranchEntity;

    @OneToMany(mappedBy = "hospitalEntity",
            cascade = CascadeType.ALL,
            targetEntity = DoctorEntity.class)
    private List<DoctorEntity> doctorEntity;
}