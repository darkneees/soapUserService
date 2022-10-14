package com.darkneees.soapuserservice.service;


import com.darkneees.soapuserservice.entity.Role;
import com.darkneees.soapuserservice.entity.RoleRef;
import com.darkneees.soapuserservice.entity.User;
import com.darkneees.soapuserservice.exception.RoleNotFoundException;
import com.darkneees.soapuserservice.exception.UserNotFoundException;
import com.darkneees.soapuserservice.repository.RoleRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
    }

    @Override
    @Async
    public CompletableFuture<Iterable<Role>> getAllRoles() {
        return CompletableFuture.supplyAsync(roleRepository::findAll);
    }

    @Override
    @Async
    public CompletableFuture<Void> createRole(Role role) {
        return CompletableFuture.runAsync(() -> {
            if(!roleRepository.existsById(role.getId())) roleRepository.save(role);
            else throw new RoleAlreadyExistException(role.getId());
        });
    }
}
