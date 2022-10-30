package com.darkneees.soapuserservice.service;

import com.darkneees.soapuserservice.entity.Social;
import com.darkneees.soapuserservice.entity.User;

import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<Void> addUser(User user);
    CompletableFuture<Void> editUser(User user);
    CompletableFuture<Void> deleteUserByUsername(String username);
    CompletableFuture<Iterable<User>> getAllUsers();
    CompletableFuture<Void> deleteRoleByUsername(String username, Long id);
    CompletableFuture<Void> addRole(String username, long role);
    CompletableFuture<User> getUserByUsernameService(String username);
    CompletableFuture<Void> addSocial(Social social, String username);

    CompletableFuture<Void> deleteSocial(String identifierSocial, String username);

}
