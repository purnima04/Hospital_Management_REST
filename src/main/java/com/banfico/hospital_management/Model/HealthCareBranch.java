package com.banfico.hospital_management.Model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class HealthCareBranch {
    @Id
    private int branch_Id;
    /*private Branches branch_name;
    private int branch_floorNo;
    private HospitalEntity hospitalEntity;*/
}