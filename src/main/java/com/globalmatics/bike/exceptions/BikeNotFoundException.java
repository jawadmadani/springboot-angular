package com.globalmatics.bike.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(String message) {
        super(message);
    }

    public BikeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
