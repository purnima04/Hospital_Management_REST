package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Hospital;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "HOSPITAL_TABLE")
public class HospitalEntity extends Hospital {
    @Column(name = "HOSPITAL_ID")
    @NotNull()
    private String hospital_Id;

    @Column(name ="HOSPITAL_NAME")
    private String hospital_name;

    @Column(name = "HOSPITAL_ADDRESS")
    private String hospital_address;

    @Column(name = "EMERGENCY_NO")
    private int hospital_emergencyNo;

    @Column(name = "HOSPITAL_MAILID")
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "check your mail id")
    private String hospital_mailId;

    @Column(name = "HOSPITAL_RESOURCES")
    @OneToOne(targetEntity = HospitalResourcesEntity.class, cascade = CascadeType.ALL, mappedBy = "hospitalEntity", fetch = FetchType.LAZY)
    private HospitalResourcesEntity hospitalResourcesEntity;

    @OneToMany(mappedBy = "hospitalEntity", targetEntity = DoctorEntity.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<DoctorEntity> doctorEntity;

    @OneToOne(targetEntity = HospitalEntity.class, cascade = CascadeType.ALL, mappedBy = "hospitalEntity", fetch = FetchType.LAZY)
    private HealthCareBranchEntity healthCareBranchEntity;
}
