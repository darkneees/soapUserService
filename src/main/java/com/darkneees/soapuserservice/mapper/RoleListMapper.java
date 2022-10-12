package com.darkneees.soapuserservice.mapper;

import com.darkneees.soapuserservice.entity.Role;
import com.darkneees.soapuserservice.entity.RoleRef;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import users_soap.api.RoleInfo;

import java.util.List;
import java.util.Set;

@Mapper(uses = {RoleMapper.class})
public interface RoleListMapper {
    RoleListMapper INSTANCE = Mappers.getMapper(RoleListMapper.class);
    Set<RoleRef> toRoleSet(List<RoleInfo> roleInfos);
    List<RoleInfo> toRoleInfo(Iterable<Role> roles);
}
