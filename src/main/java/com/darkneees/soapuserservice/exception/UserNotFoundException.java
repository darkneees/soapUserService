package com.darkneees.soapuserservice.exception;

public class UserNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public UserNotFoundException(String message) {
        super("Don't found user with username:" + message);
    }
}
