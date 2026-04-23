package com.prashant.jobapi;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
