package com.banfico.hospital_management.Model;

import com.banfico.hospital_management.Entity.AuditEntity;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Billing extends AuditEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_Id;
}
