package com.banfico.hospital_management.Model;

import com.banfico.hospital_management.Entity.AuditEntity;
import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public class Hospital extends AuditEntity {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int hospital_Id;
}