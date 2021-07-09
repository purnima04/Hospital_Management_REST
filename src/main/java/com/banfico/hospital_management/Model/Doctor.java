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
public class Doctor{
    @Id
    private int doctor_Id;
    /*private String doctor_name;
    private String doctor_designation;
    private String doctor_degree;
    private String doctor_address;
    private String doctor_emailId;
    private String doctor_contactNo;
    private HospitalEntity hospitalEntity;
    private List<PatientEntity> patientEntity;*/

}