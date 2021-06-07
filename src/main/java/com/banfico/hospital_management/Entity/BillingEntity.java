package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Billing;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BILLING_TABLE")
public class BillingEntity extends Billing {
    @Column(unique = true, nullable = false)
    @NotNull(message = "Missing Bill Id, make new one!")
    private String bill_Id;
    @Column(name = "DRUG_NAME")
    @NotEmpty
    private String medicine;
    @Max(value = 4, message = "Dosage are quiet high in number need to recheck with Doctor's prescription")
    @Column(name = "DRUG_QUANTITY")
    private int quantity;
    @Column(name = "DRUG_PER_UNIT")
    private double unitValue;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "billingEntity", targetEntity = BillGenerationEntity.class, fetch = FetchType.LAZY)
    private BillGenerationEntity billGenerationEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "billingEntity", targetEntity = BillingEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private PatientEntity patientEntity;
}
