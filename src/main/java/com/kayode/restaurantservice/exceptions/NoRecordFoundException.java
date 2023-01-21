package com.kayode.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;

public class NoRecordFoundException extends CustomException{

    private final static HttpStatus errorCode=HttpStatus.NOT_FOUND;

    private final static String message= "No record found";

    public NoRecordFoundException() {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatusCode() {
        return errorCode;
    }
}
