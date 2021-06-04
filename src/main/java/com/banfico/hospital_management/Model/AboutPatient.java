package com.banfico.hospital_management.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class AboutPatient {
    @Id
    private long patient_id;
    private String patient_address;
    private String patient_gender;
    private String patient_emailId;
    private Date patient_DOB;
}
