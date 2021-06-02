package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class HospitalResources {
    @Id
    @Column(name = "RESOURCE_ID")
    private String resource_id;
    @Column(name = "BEDS_AVAILABLE")
    private int bedsAvailable;
    @Column(name = "BEDS_IN_USE")
    private int bedsInUse;
    @OneToOne(targetEntity = Hospital.class, cascade = CascadeType.ALL, mappedBy = "hospitalResources")
    private Hospital hospital;
}
