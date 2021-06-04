package com.banfico.hospital_management.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE.SEQUENCE)
    @GenericGenerator(name="Gen", strategy="foreign")
    private long billId;
    private String medicine;
    private int quantity;
    private double unitValue;

}
