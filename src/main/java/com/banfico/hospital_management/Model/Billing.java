package com.banfico.hospital_management.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE.SEQUENCE)
    @GenericGenerator(name="Gen", strategy="foreign")
    @Column(name = "BILL_ID")
    private long billId;
    @Column(name = "DRUG_NAME")
    private String medicine;
    @Column(name = "DRUG_QUANTITY")
    private int quantity;
    @Column(name = "DRUG_PER_UNIT")
    private double unitValue;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "billing", targetEntity = BillGeneration.class)
    private BillGeneration billGeneration;

}
