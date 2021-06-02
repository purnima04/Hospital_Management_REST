package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "HOSPITAL_TABLE")
public class Hospital {
    @Id
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
    @OneToOne(targetEntity = HospitalResources.class, cascade = CascadeType.ALL, mappedBy = "hospital")
    private HospitalResources hospitalResources;
    @OneToMany(mappedBy = "hospital", targetEntity = Doctor.class, cascade = CascadeType.ALL)
    private List<Doctor> doctor;
}
