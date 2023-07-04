package com.example.irrigation.service.exception;

public class IrrigationSystemException extends RuntimeException{ // generic exception for the system
    public IrrigationSystemException(String message){
        super(message);
    }
    public IrrigationSystemException(String message, Throwable cause) {
        super(message, cause);
    }

}
