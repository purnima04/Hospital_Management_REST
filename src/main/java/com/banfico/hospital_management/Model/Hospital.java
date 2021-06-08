package com.banfico.hospital_management.Model;

import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public class Hospital {
    @Id
    private String hospital_Id;
}