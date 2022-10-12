package com.darkneees.soapuserservice.mapper;

import com.darkneees.soapuserservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import users_soap.api.UserInfo;

import java.util.List;

@Mapper(uses = {UserMapper.class})
public interface ListUserMapper {

    ListUserMapper INSTANCE = Mappers.getMapper(ListUserMapper.class);
    List<UserInfo> toListUserInfos(Iterable<User> users);

}
