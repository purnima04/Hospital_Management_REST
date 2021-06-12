package com.banfico.hospital_management.ExceptionHandler;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        super("Invalid Input");
    }
    public InvalidInputException(String message) {
        super(message);
    }
}
