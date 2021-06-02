package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class About_patient {
    @Id
    @Column(name = "PATIENT_ID")
    private long patient_id;
    @Column(name = "PATIENT_ADDRESS")
    private String patient_address;
    @Column(name = "PATIENT_GENDER")
    private String patient_gender;
    @Column(name = "PATIENT_EMAIL_ID")
    private String patient_emailId;
    @Column(name = "DOB")
    private Date patient_DOB;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "Patient_Id", nullable = false)
    private Patient patient;
}
