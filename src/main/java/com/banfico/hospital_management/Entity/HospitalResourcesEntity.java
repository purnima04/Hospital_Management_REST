package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.HospitalResources;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "HOSPITAL_RESOURCES")
@JsonPropertyOrder({"resource_Id",
        "bedsAvailable",
        "bedsInUse"})
public class HospitalResourcesEntity extends HospitalResources {

    @Column(name = "BEDS_AVAILABLE")
    private int bedsAvailable;

    @Column(name = "BEDS_IN_USE")
    private int bedsInUse;

    @OneToOne(targetEntity = HospitalEntity.class, cascade = CascadeType.ALL)
    @JsonBackReference
    private HospitalEntity hospitalEntity;
}