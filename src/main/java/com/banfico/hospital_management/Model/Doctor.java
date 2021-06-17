package com.banfico.hospital_management.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Doctor{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctor_Id;
}