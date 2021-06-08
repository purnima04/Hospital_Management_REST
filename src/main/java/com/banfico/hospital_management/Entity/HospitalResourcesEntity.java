package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.HospitalResources;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "HOSPITAL_RESOURCES")
public class HospitalResourcesEntity extends HospitalResources {

    @Column(name = "BEDS_AVAILABLE")
    private int bedsAvailable;
    @Column(name = "BEDS_IN_USE")
    private int bedsInUse;
    @OneToOne(targetEntity = HospitalEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, mappedBy = "hospitalResourcesEntity")
    @JoinColumn(name = "HOSPITAL_ID")
    @JsonIgnore
    private HospitalEntity hospitalEntity;
}