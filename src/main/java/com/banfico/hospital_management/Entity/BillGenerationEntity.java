package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.BillGeneration;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "GENERATED_BILL")
public class BillGenerationEntity extends BillGeneration {
    @NotNull
    @Column(name = "PATIENT_ID")
    private String patient_Id;
    @NotNull
    @Column(name = "DOCTOR_ID")
    private String doctor_Id;
    @Column(name = "AMOUNT_TO_BE_PAID")
    private double total_amount;
    @OneToOne
    @PrimaryKeyJoinColumn
    private BillingEntity billingEntity;
}
