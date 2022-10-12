package com.darkneees.soapuserservice.service;


import com.darkneees.soapuserservice.entity.Role;
import com.darkneees.soapuserservice.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public CompletableFuture<Iterable<Role>> getAllRoles() {
        return CompletableFuture.completedFuture(roleRepository.findAll());
    }
}
