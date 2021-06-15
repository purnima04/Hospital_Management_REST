package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Billing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
@Data
@Entity
@Table(name = "BILLING_TABLE")
@JsonPropertyOrder({"bill_Id",
        "medicine",
        "quantity",
        "unitValue"})
public class BillingEntity extends Billing {
    @Column(name = "DRUG_NAME")
    @NotEmpty
    private String medicine;

    @Max(value = 4, message = "Dosage are quiet high in number need to recheck with Doctor's prescription")
    @Column(name = "DRUG_QUANTITY")
    private int quantity;

    @Column(name = "DRUG_PER_UNIT")
    private double unitValue;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = PatientEntity.class)
    @JsonBackReference
    private PatientEntity patientEntity;
}