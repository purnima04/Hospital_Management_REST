package com.banfico.hospital_management.Model;

import com.banfico.hospital_management.Entity.AuditEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
public class Billing extends AuditEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_Id;
}
