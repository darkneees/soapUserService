package com.darkneees.soapuserservice.mapper;

import com.darkneees.soapuserservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import users_soap.api.UserInfo;

@Mapper(uses = {RoleListMapper.class, SocialListMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(source = "info.roleList", target = "roleSet")
    @Mapping(source = "info.socialList", target = "socialSet")
    User toUser(UserInfo info);

    @Mapping(source = "info.roleList", target = "roleRefSet")
    @Mapping(source = "info.socialList", target = "socialSet")
    @Mapping(target = "new", constant = "true")
    User toNewUser(UserInfo info);

    @Mapping(source = "user.roleSet", target = "roleList")
    @Mapping(source = "user.socialSet", target = "socialList")
    UserInfo toUserInfo(User user);
}
