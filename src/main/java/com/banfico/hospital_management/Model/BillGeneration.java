package com.banfico.hospital_management.Model;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BillGeneration {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "billingEntity"))
    private long generated_Id;
    /*
    private String patient_Id;
    private String doctor_Id;
    private double total_amount;
     */
}