package com.banfico.hospital_management.ExceptionHandler;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@ToString
@Data
@Getter
public class ExceptionResponse {
    private String message;

    public ExceptionResponse(String message) {
        super();
    }
}
