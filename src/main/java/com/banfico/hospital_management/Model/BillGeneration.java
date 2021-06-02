package com.banfico.hospital_management.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BillGeneration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE.IDENTITY)
    @Column(name = "GENERATED_ID")
    private long generatedId;
    @Column(name = "PATIENT_ID")
    private String patient_Id;
    @Column(name = "DOCTOR_ID")
    private String doctor_Id;
    @Column(name = "AMOUNT_TO_BE_PAID")
    private double total_amount;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Billing.class, mappedBy = "")
    @PrimaryKeyJoinColumn
    private Billing billing;

}
