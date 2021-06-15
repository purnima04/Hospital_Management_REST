package com.banfico.hospital_management.ExceptionHandler;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException() {
        super(String.format("No data found"));
    }
}