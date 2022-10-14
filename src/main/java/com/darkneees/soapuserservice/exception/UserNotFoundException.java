package com.darkneees.soapuserservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(UserNotFoundException.class);
    public UserNotFoundException(String message) {
        super("Don't found user with username:" + message);
    }

}
