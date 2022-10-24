package com.darkneees.soapuserservice.mapper;

import com.darkneees.soapuserservice.exception.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import users_soap.api.ServiceStatus;

@Mapper()
public interface ServiceStatusMapper {

    ServiceStatusMapper INSTANCE = Mappers.getMapper(ServiceStatusMapper.class);

    @Mapping(target = "success", constant = "false")
    @Mapping(source = "message", target = "errors")
    ServiceStatus toServiceStatusException(Throwable exception);

}
