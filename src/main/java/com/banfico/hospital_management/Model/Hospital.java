package com.banfico.hospital_management.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Hospital{
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int hospital_Id;
}