package com.banfico.hospital_management.Entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Branches {
    NEURO("Neuroscience"), CARDIO("Cardiology"), CANCER("Cancer");

    private String value;
    Branches(String value){
        this.value=value;
    }

    @JsonValue
    public String value(){
        return value;
    }
}
