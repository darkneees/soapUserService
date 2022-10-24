package com.darkneees.soapuserservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import users_soap.api.*;

@Mapper(uses = {ServiceStatusMapper.class})
public interface ResponseMapperException {
    ResponseMapperException INSTANCE = Mappers.getMapper(ResponseMapperException.class);

    @Mapping(source = "exception", target = "status")
    AddUserResponse toAddUserResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    DeleteUserByUsernameResponse toDeleteUserByUsernameResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    DeleteRoleByUserResponse toDeleteRoleByUserResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    AddUserRolesResponse toAddUserRolesResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    AddRoleResponse toAddRoleResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    EditUserByUsernameResponse toEditUserByUsernameResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    AddSocialResponse toAddSocialResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    DeleteSocialResponse toDeleteSocialResponse(Throwable exception);
    @Mapping(source = "exception", target = "status")
    GetUserByUsernameResponse toGetUserByUsernameResponse(Throwable exception);


}
