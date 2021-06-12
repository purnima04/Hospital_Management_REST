package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class HospitalResources {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resource_Id;
}
