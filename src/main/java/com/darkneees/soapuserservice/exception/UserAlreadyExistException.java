package com.darkneees.soapuserservice.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super("This user with username already exist: " + message);
    }
}
