package com.darkneees.soapuserservice.mapper;

import com.darkneees.soapuserservice.entity.Social;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import users_soap.api.SocialInfo;

import java.util.List;
import java.util.Set;

@Mapper(uses = {SocialMapper.class})
public interface SocialListMapper {
    SocialListMapper INSTANCE = Mappers.getMapper(SocialListMapper.class);
    Set<Social> toSocialSet(List<SocialInfo> socialInfos);
}
