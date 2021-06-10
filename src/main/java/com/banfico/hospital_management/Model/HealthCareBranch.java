package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class HealthCareBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branch_Id;
}