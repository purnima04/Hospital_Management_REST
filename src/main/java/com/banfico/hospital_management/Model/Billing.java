package com.banfico.hospital_management.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Billing{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_Id;
}
