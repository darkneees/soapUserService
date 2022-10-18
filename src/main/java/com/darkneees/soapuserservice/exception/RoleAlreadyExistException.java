package com.darkneees.soapuserservice.exception;

public class RoleAlreadyExistException extends RuntimeException {
    public RoleAlreadyExistException(Long id) {
        super("Role with id: " + id + ", already exist");
    }
}
