package com.banfico.hospital_management.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class AboutPatient {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "patientEntity"))
    private long patient_ref;
    /*
    private String patient_address;
    private String patient_gender;
    private String patient_emailId;
    private Date patient_DOB;
     */
}
