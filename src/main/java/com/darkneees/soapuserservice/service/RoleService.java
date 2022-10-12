package com.darkneees.soapuserservice.service;

import com.darkneees.soapuserservice.entity.Role;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface RoleService {

    CompletableFuture<Iterable<Role>> getAllRoles();
}
