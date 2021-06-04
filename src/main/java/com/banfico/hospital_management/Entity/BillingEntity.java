package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Billing;

import javax.persistence.*;

@Entity
@Table(name = "BILLING_TABLE")
public class BillingEntity extends Billing {
    @Column(name = "BILL_ID")
    private long billId;
    @Column(name = "DRUG_NAME")
    private String medicine;
    @Column(name = "DRUG_QUANTITY")
    private int quantity;
    @Column(name = "DRUG_PER_UNIT")
    private double unitValue;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "billingEntity", targetEntity = BillGenerationEntity.class)
    private BillGenerationEntity billGenerationEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "billingEntity", targetEntity = BillingEntity.class)
    private PatientEntity patientEntity;
}
