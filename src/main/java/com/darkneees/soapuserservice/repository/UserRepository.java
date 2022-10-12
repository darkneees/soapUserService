package com.darkneees.soapuserservice.repository;

import com.darkneees.soapuserservice.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT u FROM users u JOIN roles r on r.id=(SELECT role_id FROM users_roles ur where ur.username = u.username) where u.username=:username")
    User getUserWithRolesByUsername(@Param("username") String username);

}
