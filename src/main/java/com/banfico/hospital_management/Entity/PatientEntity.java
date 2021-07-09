package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Entity.Enum.Gender;
import com.banfico.hospital_management.Model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "PATIENT_TABLE")
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "patient_Id"
)
 */
@JsonPropertyOrder({"patient_Id",
        "patient_name",
        "patient_In",
        "patient_DOB",
        "patient_contactNumber",
        "patient_emailId",
        "patient_gender",
        "patient_address"})
public class PatientEntity extends Patient {
    private static final String MY_TIME_ZONE="Asia/Kolkata";

    @Column(name = "PATIENT_NAME")
    private String patient_name;

    @Column(name = "PATIENT_CONTACT")
    private String patient_contactNumber;

    @Column(name = "PATIENT_ADDRESS")
    private String patient_address;

    @Column(name = "PATIENT_GENDER")
    private Gender patient_gender;

    @NotNull
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "check your mail id")
    @Column(name = "PATIENT_EMAIL_ID")
    private String patient_emailId;

    @Column(name = "DOB")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date patient_DOB;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PATIENT_IN_TIME", updatable = false, nullable = false)
    @CreationTimestamp
    private Date patient_In;

    //@ManyToMany(targetEntity = DoctorEntity.class, cascade = {CascadeType.REFRESH, CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH})
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = DoctorEntity.class)
    @JoinColumn(name = "doctorRef", referencedColumnName = "doctor_Id")
    @JsonBackReference
    private DoctorEntity doctorEntity;

    //private List<DoctorEntity> doctorEntity;

    @OneToOne(targetEntity = BillingEntity.class, mappedBy = "patientEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private BillingEntity billingEntity;
}
