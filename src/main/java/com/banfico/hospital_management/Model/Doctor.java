package com.banfico.hospital_management.Model;

import com.banfico.hospital_management.Entity.AuditEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Doctor extends AuditEntity {
    @Id
    //@Column(name = "DOCTOR_ID")
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String doctor_Id;
    //private String doctor_name;
    /*
    private String doctor_designation;
    private String doctor_degree;
    private String doctor_address;
    private String doctor_emailId;
    private long doctor_contactNo;
     */
}
