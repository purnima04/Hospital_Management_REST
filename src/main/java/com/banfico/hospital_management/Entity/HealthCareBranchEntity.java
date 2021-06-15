package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Entity.ENUM.Branches;
import com.banfico.hospital_management.Model.HealthCareBranch;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "DEPARTMENT_TABLE")
@JsonPropertyOrder({"branch_Id",
        "branch_name",
        "branch_floorNo"})
public class HealthCareBranchEntity extends HealthCareBranch {
    @Column(name = "BRANCH_NAME")
    private Branches branch_name;

    @Column(name = "BRANCH_FLOOR_NO")
    //@Max(value = 10, message = "Exceeded the floor")
    private int branch_floorNo;

    @OneToOne(targetEntity = HospitalEntity.class, cascade = CascadeType.ALL)
    @JsonBackReference
    private HospitalEntity hospitalEntity;
}