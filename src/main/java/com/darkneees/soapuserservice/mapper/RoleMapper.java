package com.darkneees.soapuserservice.mapper;

import com.darkneees.soapuserservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import users_soap.api.RoleInfo;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    Role toRole(RoleInfo roleInfo);

}
