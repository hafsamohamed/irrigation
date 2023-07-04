package com.example.irrigation.service.exception;

public class ResourceAlreadyExistException extends IrrigationSystemException {
    public ResourceAlreadyExistException(String message){
        super(message);
    }
    public ResourceAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
