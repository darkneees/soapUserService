package com.darkneees.soapuserservice.exception;

public class UserAlreadyExistException extends RuntimeException {

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public UserAlreadyExistException(String message) {
        super("This user with username already exist: " + message);
    }
}
