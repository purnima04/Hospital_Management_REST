package com.banfico.hospital_management.Model;

import com.banfico.hospital_management.Entity.AuditEntity;
import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class Patient extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patient_Id;
    /*
    private String patient_name;
    private long patient_contactNumber;
    private Timestamp patient_In;
    private Timestamp patient_Out;
     */
}
