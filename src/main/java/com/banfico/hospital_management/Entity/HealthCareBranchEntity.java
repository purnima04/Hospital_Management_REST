package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.HealthCareBranch;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
@Data
@Entity
@Table(name = "DEPARTMENT_TABLE")
public class HealthCareBranchEntity extends HealthCareBranch {
    @Column(name = "BRANCH_NAME")
    private String branch_name;

    @Column(name = "BRANCH_FLOOR_NO")
    //@Max(value = 10, message = "Exceeded the floor")
    private int branch_floorNo;

    @OneToOne(targetEntity = HospitalEntity.class, cascade = CascadeType.ALL)
    @JsonBackReference
    private HospitalEntity hospitalEntity;
}