package com.banfico.hospital_management.Entity;

import com.banfico.hospital_management.Model.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "PATIENT_TABLE")
public class PatientEntity extends Patient {
    @Column(name = "PATIENT_NAME")
    private String patient_name;

    @Column(name = "PATIENT_CONTACT")
    private String patient_contactNumber;

    @OneToOne( mappedBy = "patientEntity", cascade = CascadeType.ALL)
    private AboutPatientEntity aboutPatientEntity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PATIENT_IN_TIME", nullable = false, updatable = false)
    @CreatedDate
    private Date patient_In;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PATIENT_OUT_TIME", nullable = false)
    @LastModifiedDate
    private Date patient_Out;
    @ManyToMany(mappedBy = "patientEntity", cascade = {CascadeType.ALL})
    private Set<DoctorEntity> doctorEntity=new HashSet<DoctorEntity>();
    @OneToOne(targetEntity =BillingEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BillingEntity billingEntity;
}
