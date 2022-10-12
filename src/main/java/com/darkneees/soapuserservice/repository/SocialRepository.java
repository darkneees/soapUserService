package com.darkneees.soapuserservice.repository;

import com.darkneees.soapuserservice.entity.Social;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository extends CrudRepository<Social, String> {
}
