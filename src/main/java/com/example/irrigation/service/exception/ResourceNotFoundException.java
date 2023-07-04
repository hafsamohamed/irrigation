package com.example.irrigation.service.exception;

public class ResourceNotFoundException extends IrrigationSystemException {
    public ResourceNotFoundException(String message){
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
