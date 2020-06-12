package com.onlineApp.ExceptionHandler;

public class ResourceAlreadyExistException extends RuntimeException {

    public ResourceAlreadyExistException(String message) {
        super(message);
    }
}
