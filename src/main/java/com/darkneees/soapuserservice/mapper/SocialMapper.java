package com.darkneees.soapuserservice.mapper;

import com.darkneees.soapuserservice.entity.Social;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import users_soap.api.SocialInfo;

@Mapper
public interface SocialMapper {

    SocialMapper INSTANCE = Mappers.getMapper(SocialMapper.class);

    @Mapping(target = "id", ignore = true)
    Social toSocial(SocialInfo socialInfo);
}
