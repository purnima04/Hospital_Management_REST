package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.HospitalResources;

import javax.persistence.*;

@Entity
@Table(name = "HOSPITAL_RESOURCES")
public class HospitalResourcesEntity extends HospitalResources {

    @Column(name = "RESOURCE_ID")
    private String resource_id;
    @Column(name = "BEDS_AVAILABLE")
    private int bedsAvailable;
    @Column(name = "BEDS_IN_USE")
    private int bedsInUse;
    @OneToOne(targetEntity = HospitalEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITAL_ID")
    private HospitalEntity hospitalEntity;
}
