package com.banfico.hospital_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class HospitalResources {
    @Id
    private String resource_id;
    /*
    private int bedsAvailable;
    private int bedsInUse;
     */
}
