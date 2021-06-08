package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Billing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "BILLING_TABLE")
public class BillingEntity extends Billing {
    @Column(name = "DRUG_NAME")
    @NotEmpty
    private String medicine;
    @Max(value = 4, message = "Dosage are quiet high in number need to recheck with Doctor's prescription")
    @Column(name = "DRUG_QUANTITY")
    private int quantity;
    @Column(name = "DRUG_PER_UNIT")
    private double unitValue;
    @OneToOne( mappedBy = "billingEntity", cascade = CascadeType.ALL)
    private BillGenerationEntity billGenerationEntity;
    @OneToOne(targetEntity = PatientEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, mappedBy = "billingEntity")
    @JoinColumn(name = "patient_Id")
    private PatientEntity patientEntity;
}
