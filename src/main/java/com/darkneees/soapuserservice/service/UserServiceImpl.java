package com.darkneees.soapuserservice.service;

import com.darkneees.soapuserservice.entity.Role;
import com.darkneees.soapuserservice.entity.RoleRef;
import com.darkneees.soapuserservice.entity.User;
import com.darkneees.soapuserservice.exception.UserNotFoundException;
import com.darkneees.soapuserservice.repository.RoleRepository;
import com.darkneees.soapuserservice.repository.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public CompletableFuture<User> getUserByUsername(String username) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<User> opt = userRepository.findById(username);
            if(opt.isPresent()) {
                User user = opt.get();
                Iterable<Role> roleSet = roleRepository.findAllById(user.getRoleRefSet()
                        .stream().map(RoleRef::getId)
                        .collect(Collectors.toSet()));
                roleSet.forEach((role) -> user.getRoleSet().add(role));

                return user;
            } else throw new UserNotFoundException(username);
        });
    }

    @Override
    @Async
    public CompletableFuture<User> saveUser(User user) {
        return CompletableFuture.completedFuture(userRepository.save(user));
    }

    @Override
    @Async
    public CompletableFuture<User> editUser(User user) {
        return CompletableFuture.completedFuture(userRepository.save(user));
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteUserByUsername(String username) {
        return CompletableFuture.runAsync(() -> userRepository.deleteById(username));
    }
    @Override
    @Async
    public CompletableFuture<Iterable<User>> getAllUsers() {
        return CompletableFuture.completedFuture(userRepository.findAll());
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteRoleByUsername(String username, Long id) {
        return CompletableFuture.runAsync(() -> {
            User user = getUserByUsername(username).join();
            user.setNew(false);
            user.getRoleRefSet().remove(new RoleRef(id));
            userRepository.save(user);
        });
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteAll() {
        return CompletableFuture.runAsync(userRepository::deleteAll);
    }

    @Override
    @Async
    public CompletableFuture<Void> addRole(String username, long role) {
        return CompletableFuture.runAsync(() -> {
            User user = getUserByUsername(username).join();
            user.getRoleRefSet().add(new RoleRef(role));
            userRepository.save(user);
        });
    }
}
