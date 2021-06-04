package com.banfico.hospital_management.Model;

import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public class Hospital {
    @Id
    private String hospital_Id;
    private String hospital_name;
    private String hospital_address;
    private int hospital_emergencyNo;
    private String hospital_mailId;
}
