package com.darkneees.soapuserservice.service;

import com.darkneees.soapuserservice.entity.Social;
import com.darkneees.soapuserservice.entity.User;
import users_soap.api.UserInfo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<User> getUserByUsername(String username);
    CompletableFuture<User> saveUser(User user);
    CompletableFuture<User> editUser(User user);
    CompletableFuture<Void> deleteUserByUsername(String username);
    CompletableFuture<Iterable<User>> getAllUsers();
    CompletableFuture<Void> deleteRoleByUsername(String username, Long id);
    CompletableFuture<Void> deleteAll();
    CompletableFuture<Void> addRole(String username, long role);
}
