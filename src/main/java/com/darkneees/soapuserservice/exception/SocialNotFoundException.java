package com.darkneees.soapuserservice.exception;

public class SocialNotFoundException extends RuntimeException {
    public SocialNotFoundException(String identifierSocial) {
        super("Social with identifier: " + identifierSocial + ", don't found");
    }
}
