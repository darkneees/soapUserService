package com.darkneees.soapuserservice.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(long role) {
        super("Role with id: " + role + ", don't found.");
    }
}
