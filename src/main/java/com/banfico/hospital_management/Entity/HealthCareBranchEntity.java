package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.HealthCareBranch;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "DEPARTMENT_TABLE")
public class HealthCareBranchEntity extends HealthCareBranch {
    @Column(name = "BRANCH_CODE")
    private String branch_code;
    @Column(name = "BRANCH_NAME")
    private String branch_name;
    @Column(name = "BRANCH_FLOOR_NO")
    @Max(value = 10, message = "Exceeded the floor")
    private int branch_floorNo;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = HospitalEntity.class, mappedBy = "healthCareBranchEntity")
    @JoinColumn(name = "HOSPITAL_ID")
    private HospitalEntity hospitalEntity;
}
