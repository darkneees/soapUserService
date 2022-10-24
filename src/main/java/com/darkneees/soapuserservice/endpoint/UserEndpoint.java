package com.darkneees.soapuserservice.endpoint;

import com.darkneees.soapuserservice.exception.*;
import com.darkneees.soapuserservice.mapper.*;
import com.darkneees.soapuserservice.service.RoleServiceImpl;
import com.darkneees.soapuserservice.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import users_soap.api.*;

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

        return userService.getAllUsers()
                .thenApply((users) -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    GetAllUsersResponse response = new GetAllUsersResponse();
                    response.setStatus(serviceStatus);
                    response.getUsers().addAll(ListUserMapper.INSTANCE.toListUserInfos(users));
                    return response;
                }).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllRolesRequest")
    @ResponsePayload
    public GetAllRolesResponse getAllRoles(){

        return roleService.getAllRoles()
                .thenApply((roles) -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    GetAllRolesResponse response = new GetAllRolesResponse();
                    response.setStatus(serviceStatus);
                    response.getRoles().addAll(RoleListMapper.INSTANCE.toRoleInfo(roles));
                    return response;

                }).join();

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {

        return userService.addUser(UserMapper.INSTANCE.toNewUser(request.getUser()))
                .thenApply(f -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    AddUserResponse response = new AddUserResponse();
                    response.setStatus(serviceStatus);
                    return response;
                })
                .exceptionally(ResponseMapperException.INSTANCE::toAddUserResponse).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByUsernameRequest")
    @ResponsePayload
    public GetUserByUsernameResponse getUserByUsername(@RequestPayload GetUserByUsernameRequest request) {

        return userService.getUserByUsernameService(request.getUsername())
                .thenApply((user) -> {

                    log.info("getUserByUsername");
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    GetUserByUsernameResponse response = new GetUserByUsernameResponse();
                    response.setStatus(serviceStatus);
                    response.setUsers(UserMapper.INSTANCE.toUserInfo(user));
                    return response;
                })
                .exceptionally(ResponseMapperException.INSTANCE::toGetUserByUsernameResponse).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserByUsernameRequest")
    @ResponsePayload
    public DeleteUserByUsernameResponse deleteUserByUsername(@RequestPayload DeleteUserByUsernameRequest request) {

        return userService.deleteUserByUsername(request.getUsername())
                .thenApply(f -> {

                    DeleteUserByUsernameResponse response = new DeleteUserByUsernameResponse();
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    response.setStatus(serviceStatus);
                    return response;
                })
                .exceptionally(ResponseMapperException.INSTANCE::toDeleteUserByUsernameResponse).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteRoleByUserRequest")
    @ResponsePayload
    public DeleteRoleByUserResponse deleteRoleByUser(@RequestPayload DeleteRoleByUserRequest request) {

        return userService.deleteRoleByUsername(request.getUsername(),
                                request.getRole())
                .thenApply(f -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    DeleteRoleByUserResponse response = new DeleteRoleByUserResponse();
                    response.setStatus(serviceStatus);
                    return response;
                })
                .exceptionally(ResponseMapperException.INSTANCE::toDeleteRoleByUserResponse).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRolesRequest")
    @ResponsePayload
    public AddUserRolesResponse addUserRoles(@RequestPayload AddUserRolesRequest request) {

        return userService.addRole(request.getUsername(), request.getRole())
                .thenApply(f -> {

            ServiceStatus serviceStatus = new ServiceStatus();
            serviceStatus.setSuccess(true);

            AddUserRolesResponse response = new AddUserRolesResponse();
            response.setStatus(serviceStatus);
            return response;
        })
                .exceptionally(ResponseMapperException.INSTANCE::toAddUserRolesResponse).join();
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRoleRequest")
    @ResponsePayload
    public AddRoleResponse addRole(@RequestPayload AddRoleRequest request) {
        return roleService.createRole(RoleMapper.INSTANCE.toRole(request.getRoles()))
                .thenApply(f -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);
                    AddRoleResponse response = new AddRoleResponse();
                    response.setStatus(serviceStatus);
                    return response;
                })
                .exceptionally(ResponseMapperException.INSTANCE::toAddRoleResponse).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editUserByUsernameRequest")
    @ResponsePayload
    public EditUserByUsernameResponse editUserByUsername(@RequestPayload EditUserByUsernameRequest request) {
        return userService.editUser(UserMapper.INSTANCE.toUser(request.getUser()))
                .thenApply(f -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);
                    EditUserByUsernameResponse response = new EditUserByUsernameResponse();
                    response.setStatus(serviceStatus);
                    return response;
                }).exceptionally(ResponseMapperException.INSTANCE::toEditUserByUsernameResponse).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addSocialRequest")
    @ResponsePayload
    public AddSocialResponse addSocial(@RequestPayload AddSocialRequest request) {
        return userService.addSocial(SocialMapper.INSTANCE.toSocial(request.getSocial()), request.getUsername())
                .thenApply(f -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    AddSocialResponse response = new AddSocialResponse();
                    response.setStatus(serviceStatus);
                    return response;
                })
                .exceptionally(ResponseMapperException.INSTANCE::toAddSocialResponse).join();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteSocialRequest")
    @ResponsePayload
    public DeleteSocialResponse deleteSocial(@RequestPayload DeleteSocialRequest request) {
        return userService.deleteSocial(request.getIdentifierSocial(), request.getUsername())
                .thenApply( f -> {

                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(true);

                    DeleteSocialResponse response = new DeleteSocialResponse();
                    response.setStatus(serviceStatus);
                    return response;
                })
                .exceptionally((ex) -> {
                    ServiceStatus serviceStatus = new ServiceStatus();
                    serviceStatus.setSuccess(false);
                    serviceStatus.setErrors(ex.getMessage());

                    DeleteSocialResponse response = new DeleteSocialResponse();
                    response.setStatus(serviceStatus);

                    return response;
                }).join();
    }

}
