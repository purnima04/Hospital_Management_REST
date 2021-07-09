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
public class HospitalResources {
    @Id
    private int resource_Id;
    /*private int bedsAvailable;
    private int bedsInUse;
    private HospitalEntity hospitalEntity;*/

}
