package com.banfico.hospital_management.Entity;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.GeneratedValue;

public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHERS("Others");
    private String value;
    Gender(String value){
        this.value=value;
    }

    @JsonValue
    public String value(){
        return value;
    }
}
