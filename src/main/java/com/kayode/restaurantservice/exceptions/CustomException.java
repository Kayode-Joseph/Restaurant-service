package com.kayode.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException  {

    public CustomException(String message) {
        super(message);
    }

   public abstract HttpStatus getHttpStatusCode();
}
