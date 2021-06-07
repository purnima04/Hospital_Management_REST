package com.banfico.hospital_management.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="Gen", strategy="foreign")
    private String bill_Id= UUID.randomUUID().toString();
    private String medicine;
    private int quantity;
    private double unitValue;
}
