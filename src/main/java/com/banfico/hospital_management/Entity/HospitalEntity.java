package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Hospital;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DOCTOR_TABLE")
public class HospitalEntity extends Hospital {
    @Column(name = "HOSPITAL_ID")
    private String hospital_Id;
    @Column(name ="HOSPITAL_NAME")
    private String hospital_name;
    @Column(name = "HOSPITAL_ADDRESS")
    private String hospital_address;
    @Column(name = "EMERGENCY_NO")
    private int hospital_emergencyNo;
    @Column(name = "HOSPITAL_MAILID")
    private String hospital_mailId;
    @Column(name = "HOSPITAL_RESOURCES")
    @OneToOne(targetEntity = HospitalResourcesEntity.class, cascade = CascadeType.ALL, mappedBy = "hospital")
    private HospitalResourcesEntity hospitalResourcesEntity;
    @OneToMany(mappedBy = "hospital", targetEntity = DoctorEntity.class, cascade = CascadeType.ALL)
    private List<DoctorEntity> doctorEntity;
    @OneToOne(targetEntity = HospitalEntity.class, mappedBy = "hospitalEntity", cascade = CascadeType.ALL)
    private HealthCareBranchEntity healthCareBranchEntity;
}
