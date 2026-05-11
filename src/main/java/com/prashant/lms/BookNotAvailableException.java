package com.prashant.lms;

public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException(String message){
        super(message);
    }
}
