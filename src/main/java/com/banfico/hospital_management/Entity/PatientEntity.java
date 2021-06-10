package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Patient;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "PATIENT_TABLE")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "patient_Id"
)
public class PatientEntity extends Patient {
    private static final String MY_TIME_ZONE="Asia/Kolkata";

    @Column(name = "PATIENT_NAME")
    private String patient_name;

    @Column(name = "PATIENT_CONTACT")
    private String patient_contactNumber;

    @Column(name = "PATIENT_ADDRESS")
    private String patient_address;

    @Column(name = "PATIENT_GENDER")
    private String patient_gender;

    @NotNull
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "check your mail id")
    @Column(name = "PATIENT_EMAIL_ID")
    private String patient_emailId;

    @Column(name = "DOB")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date patient_DOB;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PATIENT_IN_TIME", updatable = false, nullable = false)
    @CreatedDate
    private Date patient_In;

    @ManyToMany(targetEntity = DoctorEntity.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<DoctorEntity> doctorEntity;

    @OneToOne(targetEntity = BillingEntity.class, mappedBy = "patientEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private BillingEntity billingEntity;
}