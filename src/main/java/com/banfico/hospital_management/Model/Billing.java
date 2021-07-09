package com.banfico.hospital_management.Model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Billing{
    @Id
    private int bill_Id;
    /*private String medicine;
    private int quantity;
    private double unitValue;
    private PatientEntity patientEntity;*/
}
