package com.banfico.hospital_management.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BillGeneration {
    @Id
    private String generatedId;
    private String patient_Id;
    private String doctor_Id;
    private double total_amount;

}
