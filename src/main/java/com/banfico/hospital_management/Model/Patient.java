package com.banfico.hospital_management.Model;

import com.banfico.hospital_management.Entity.AuditEntity;
import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class Patient extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patient_Id;
}
