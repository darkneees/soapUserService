package com.darkneees.soapuserservice.service;

import com.darkneees.soapuserservice.endpoint.UserEndpoint;
import com.darkneees.soapuserservice.entity.Role;
import com.darkneees.soapuserservice.entity.RoleRef;
import com.darkneees.soapuserservice.entity.Social;
import com.darkneees.soapuserservice.entity.User;
import com.darkneees.soapuserservice.exception.*;
import com.darkneees.soapuserservice.repository.RoleRepository;
import com.darkneees.soapuserservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    private User getUserByUsername(String username) {
            Optional<User> opt = userRepository.findById(username);
            if(opt.isPresent()) {
                User user = opt.get();
                Iterable<Role> roleSet = roleRepository.findAllById(user.getRoleRefSet()
                        .stream().map(RoleRef::getId)
                        .collect(Collectors.toSet()));
                roleSet.forEach((role) -> user.getRoleSet().add(role));
                log.info("Get user: {}", user);
                return user;
            } else throw new UserNotFoundException(username);
    }

    @Async
    @Override
    public CompletableFuture<Void> addUser(User user) {
        return CompletableFuture.runAsync(() -> {
            if(!userRepository.existsById(user.getUsername())){
                  User savedUser = userRepository.save(user);
                  log.info("Saved user: {}", savedUser);
            }
            else throw new UserAlreadyExistException(user.getUsername());
        });
    }
    @Override
    @Async
    public CompletableFuture<Void> editUser(User user) {
        return CompletableFuture.runAsync(() -> {
            user.getRoleRefSet().addAll(user.getRoleSet().stream()
                    .map((el) -> new RoleRef(el.getId()))
                    .collect(Collectors.toSet()));
            User editUser = userRepository.save(user);
            log.info("Edit user: {}", editUser);
        });
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteUserByUsername(String username) {
        return CompletableFuture.runAsync(() -> {
            if(userRepository.findById(username).isPresent()) {
                userRepository.deleteById(username);
                log.info("Deleted in database user with username: {}", username);
            }
            else throw new UserNotFoundException(username);
        });
    }
    @Override
    @Async
    public CompletableFuture<Iterable<User>> getAllUsers() {
        return CompletableFuture.supplyAsync(userRepository::findAll);
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteRoleByUsername(String username, Long id) {
        return CompletableFuture.runAsync(() -> {
            User user = getUserByUsername(username);
            user.setNew(false);
            if(user.getRoleRefSet().remove(new RoleRef(id))) {
                userRepository.save(user);
                log.info("Delete role with id: {} in user with username: {}", id, username);
            }
            else throw new UserRoleNotFoundException(username, id);
        });
    }
    @Override
    @Async
    public CompletableFuture<Void> addRole(String username, long role) {
        return CompletableFuture.runAsync(() -> {
            User user = getUserByUsername(username);
            if(roleRepository.findById(role).isPresent()) {
                user.getRoleRefSet().add(new RoleRef(role));
                userRepository.save(user);
                log.info("Add role with id: {}, for user with username: {}", role, username);
            } else throw new RoleNotFoundException(role);

        });
    }

    @Override
    @Async
    public CompletableFuture<User> getUserByUsernameService(String username) {
        return CompletableFuture.supplyAsync(() -> getUserByUsername(username));
    }

    @Override
    public CompletableFuture<Void> addSocial(Social social, String username) {
        return CompletableFuture.runAsync(() -> {
            User user = getUserByUsername(username);
            user.getSocialSet().add(social);
            log.info("Add social for user with username: {}, social: {}, {}", username, social.getIdentifierSocial(), social.getNameSocial());
            userRepository.save(user);
        });
    }

    @Override
    public CompletableFuture<Void> deleteSocial(String identifierSocial, String username) {
        return CompletableFuture.runAsync(() -> {
            User user = getUserByUsername(username);
            if(user.getSocialSet()
                    .removeIf((ef) -> ef.getIdentifierSocial().equals(identifierSocial))) {
                userRepository.save(user);
                log.info("Delete social by user with username: {}, social: {}", username, identifierSocial);
            }
            else throw new SocialNotFoundException(identifierSocial);
        });
    }


}
