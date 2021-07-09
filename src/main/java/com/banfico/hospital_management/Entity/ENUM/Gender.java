package com.banfico.hospital_management.Entity.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHERS("Others");
    private String value;
    Gender(String value){
        this.value=value;
    }

    @JsonValue
    public String value() {
        return value;
    }
}
