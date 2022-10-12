package com.darkneees.soapuserservice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super("Don't found user with username:" + message);
    }

}
