package com.darkneees.soapuserservice.endpoint;

import com.darkneees.soapuserservice.mapper.ListUserMapper;
import com.darkneees.soapuserservice.mapper.RoleListMapper;
import com.darkneees.soapuserservice.mapper.UserMapper;
import com.darkneees.soapuserservice.service.RoleServiceImpl;
import com.darkneees.soapuserservice.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import users_soap.api.*;

import java.util.concurrent.CompletableFuture;

@Endpoint
public class UserEndpoint {

    private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);
    private static final String NAMESPACE_URI="http://users-soap/api/";
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public UserEndpoint(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers() {

        return CompletableFuture.supplyAsync(userService::getAllUsers)
                .thenApply((users) -> {

                    log.info("getAllUsers");
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    GetAllUsersResponse response = new GetAllUsersResponse();
                    response.setStatus(serviceStatus);
                    response.getUsers().addAll(ListUserMapper.INSTANCE.toListUserInfos(users.join()));
                    return response;
                }).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllRolesRequest")
    @ResponsePayload
    public GetAllRolesResponse getAllRoles(){

        return CompletableFuture.supplyAsync(roleService::getAllRoles)
                .thenApply((roles) -> {

                    log.info("getAllRoles");
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);



                    GetAllRolesResponse response = new GetAllRolesResponse();
                    response.setStatus(serviceStatus);
                    response.getRoles().addAll(RoleListMapper.INSTANCE.toRoleInfo(roles.join()));
                    return response;

                }).join();

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {

        return CompletableFuture.supplyAsync(() -> userService.saveUser(UserMapper.INSTANCE.toNewUser(request.getUser())))
                .thenApply(f -> {
                    log.info(UserMapper.INSTANCE.toNewUser(request.getUser()).toString());
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    AddUserResponse response = new AddUserResponse();
                    response.setServiceStatus(serviceStatus);
                    return response;
                })
                .exceptionally((ex) -> {
            ServiceStatus serviceStatus = new ServiceStatus();
            serviceStatus.setSuccess(false);
            serviceStatus.setErrors(ex.getMessage());

            AddUserResponse response = new AddUserResponse();
            response.setServiceStatus(serviceStatus);

            return response;
        }).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByUsernameRequest")
    @ResponsePayload
    public GetUserByUsernameResponse getUserByUsername(@RequestPayload GetUserByUsernameRequest request) {

        return CompletableFuture.supplyAsync(() -> userService.getUserByUsername(request.getUsername()))
                .thenApply((user) -> {

                    log.info("getUserByUsername");
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    GetUserByUsernameResponse response = new GetUserByUsernameResponse();
                    response.setStatus(serviceStatus);
                    response.setUsers(UserMapper.INSTANCE.toUserInfo(user.join()));
                    return response;

                }).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserByUsernameRequest")
    @ResponsePayload
    public DeleteUserByUsernameResponse deleteUserByUsername(@RequestPayload DeleteUserByUsernameRequest request) {

        return CompletableFuture.supplyAsync(() -> userService.deleteUserByUsername(request.getUsername()))
                .thenApply(f -> {

                    DeleteUserByUsernameResponse response = new DeleteUserByUsernameResponse();
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    response.setStatus(serviceStatus);

                    return response;

                }).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteRoleByUserRequest")
    @ResponsePayload
    public DeleteRoleByUserResponse deleteRoleByUser(@RequestPayload DeleteRoleByUserRequest request) {

        return CompletableFuture.supplyAsync(() ->
                        userService.deleteRoleByUsername(request.getUsername(),
                                request.getRole()))
                .thenApply(f -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    DeleteRoleByUserResponse response = new DeleteRoleByUserResponse();
                    response.setStatus(serviceStatus);
                    return response;
                }).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRolesRequest")
    @ResponsePayload
    public AddUserRolesResponse addUserRoles(@RequestPayload AddUserRolesRequest request) {

        return CompletableFuture.supplyAsync(() ->
            userService.addRole(request.getUsername(), request.getRole())).thenApply(f -> {

            ServiceStatus serviceStatus = new ServiceStatus();
            serviceStatus.setSuccess(true);

            AddUserRolesResponse response = new AddUserRolesResponse();
            response.setStatus(serviceStatus);
            return response;
        }).join();
    }
}
