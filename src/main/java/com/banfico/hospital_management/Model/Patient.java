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
public class Patient{
    @Id
    private int patient_Id;
    /*private String patient_name;
    private String patient_contactNumber;
    private String patient_address;
    private PatientEntity.Gender patient_gender;
    private String patient_emailId;
    private Date patient_DOB;
    private Date patient_In;
    private DoctorEntity doctorEntity;
    private BillingEntity billingEntity;*/
}
