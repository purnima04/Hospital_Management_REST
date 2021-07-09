package com.banfico.hospital_management.Model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Hospital{
    @Id
    private int hospital_Id;
    /*private String hospital_name;
    private String hospital_address;
    private int hospital_emergencyNo;
    private String hospital_mailId;
    private HospitalResourcesEntity hospitalResourcesEntity;
    private HealthCareBranchEntity healthCareBranchEntity;
    private List<DoctorEntity> doctorEntity;*/
}