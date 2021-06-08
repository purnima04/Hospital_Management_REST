package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class HealthCareBranch {
    @Id
    private String branch_code;
    /*
    private String branch_name;
    private int branch_floorNo;
     */
}