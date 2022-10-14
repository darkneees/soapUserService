package com.darkneees.soapuserservice.exception;

public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException(String username, Long id) {
        super("The user with username: " + username + ", does not have such a role with id: " + id);
    }
}
