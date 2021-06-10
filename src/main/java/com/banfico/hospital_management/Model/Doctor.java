package com.banfico.hospital_management.Model;

import com.banfico.hospital_management.Entity.AuditEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Doctor extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_Id;
}
