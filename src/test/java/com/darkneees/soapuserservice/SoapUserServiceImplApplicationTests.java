package com.darkneees.soapuserservice;

import com.darkneees.soapuserservice.entity.Role;
import com.darkneees.soapuserservice.entity.Social;
import com.darkneees.soapuserservice.entity.User;
import com.darkneees.soapuserservice.exception.UserNotFoundException;
import com.darkneees.soapuserservice.mapper.ResponseMapperException;
import com.darkneees.soapuserservice.mapper.ServiceStatusMapper;
import com.darkneees.soapuserservice.mapper.UserMapper;
import com.darkneees.soapuserservice.repository.UserRepository;
import com.darkneees.soapuserservice.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import users_soap.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SoapUserServiceImplApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(SoapUserServiceImplApplicationTests.class);

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository repository;

    @BeforeEach
    public void init(){
//        userService.deleteAll().join();
    }

    @Test
    @Disabled
    public void createClearUser(){
        log.info("Test create clear user");
        User user = new User(
                "darkneees",
                "Andrey",
                "Nesterov",
                22,
                "password",
                true
        );

        userService.addUser(user);

        User savedUser = userService.getUserByUsernameService(user.getUsername()).join();
        log.info(savedUser.toString());
        assertEquals(user, savedUser);
    }

    @Test
    @Disabled
    public void createSocialUser(){
        log.info("Test create user with social");
        User user = new User("darkneees",
                "Andrey",
                "Nesterov",
                22,
                "password",
                true);
        Social vk = new Social("Vkontakte", "VK");
        Social tg = new Social("Telegram", "TG");
        Social ok = new Social("Odnoklassniki", "OK");

        user.addSocial(vk);
        user.addSocial(tg);
        user.addSocial(ok);

//        User savedUser = userService.addUser(user).join();
//        log.info(savedUser.toString());
//        assertEquals(user, savedUser);
    }

    @Test
    @Disabled
    public void createRoleUser() {
        log.info("Test create user with roles");
        User user = new User("darkneees",
                "Andrey",
                "Nesterov",
                22,
                "password",
                true);

        Role r1 = new Role(1L);
        Role r2 = new Role(2L);

        user.addRoleRef(r1);
        user.addRoleRef(r2);

//        User savedUser = userService.addUser(user).join();
//        log.info(savedUser.toString());
//        assertEquals(user, savedUser);

    }

    @Test
    @Disabled
    public void deleteUserByUsername() {
        log.info("Test delete user");
        userService.deleteUserByUsername("darkneees");
    }

    @Test
    @Disabled
    public void createRoleAndSocialUser(){
        log.info("Test create user with roles and social");

        User user = new User("darkneees",
                "Andrey",
                "Nesterov",
                22,
                "password",
                true);

        Social vk = new Social("Vkontakte", "VK");
        Social tg = new Social("Telegram", "TG");
        Social ok = new Social("Odnoklassniki", "OK");

        user.addSocial(vk);
        user.addSocial(tg);
        user.addSocial(ok);

        Role r1 = new Role(1L);
        Role r2 = new Role(2L);

        user.addRoleRef(r1);
        user.addRoleRef(r2);

//        User savedUser = userService.addUser(user).join();
//        log.info(savedUser.toString());
//        assertEquals(user, savedUser);
    }

    @Test
    @Disabled
    public void findByUsername(){
        User user = userService.getUserByUsernameService("darkneees").join();

        log.info(user.toString());
        assertEquals(user.getSocialSet().size(), 3);
        assertEquals(user.getRoleRefSet().size(), 2);
    }

    @Test
    @Disabled
    public void userMapper(){
        UserInfo userInfo = new UserInfo();

        userInfo.setUsername("darkneees");
        userInfo.setFirstName("Andrey");
        userInfo.setSecondName("Nesterov");
        userInfo.setAge(22);
        userInfo.setPassword("password");

        RoleInfo r1 = new RoleInfo();
        r1.setId(1L);
        RoleInfo r2 = new RoleInfo();
        r2.setId(2L);

        userInfo.getRoleList().add(r1);
        userInfo.getRoleList().add(r2);

        SocialInfo vk = new SocialInfo();
        vk.setNameSocial("Vkontakte");
        vk.setIdentifierSocial("VK");
        SocialInfo tg = new SocialInfo();
        tg.setNameSocial("Telegram");
        tg.setIdentifierSocial("TG");
        SocialInfo ok = new SocialInfo();
        ok.setNameSocial("Odnoklassniki");
        ok.setIdentifierSocial("OK");

        userInfo.getSocialList().add(vk);
        userInfo.getSocialList().add(tg);
        userInfo.getSocialList().add(ok);


        User user = UserMapper.INSTANCE.toUser(userInfo);
        log.info(user.toString());
    }

    @Test
    @Disabled
    public void createUserInDbFromSoapService(){
        UserInfo userInfo = new UserInfo();

        userInfo.setUsername("darkneees");
        userInfo.setFirstName("Andrey");
        userInfo.setSecondName("Nesterov");
        userInfo.setAge(22);
        userInfo.setPassword("password");

        RoleInfo r1 = new RoleInfo();
        r1.setId(1L);
        RoleInfo r2 = new RoleInfo();
        r2.setId(2L);

        userInfo.getRoleList().add(r1);
        userInfo.getRoleList().add(r2);

        SocialInfo vk = new SocialInfo();
        vk.setNameSocial("Vkontakte");
        vk.setIdentifierSocial("VK");
        SocialInfo tg = new SocialInfo();
        tg.setNameSocial("Telegram");
        tg.setIdentifierSocial("TG");
        SocialInfo ok = new SocialInfo();
        ok.setNameSocial("Odnoklassniki");
        ok.setIdentifierSocial("OK");

        userInfo.getSocialList().add(vk);
        userInfo.getSocialList().add(tg);
        userInfo.getSocialList().add(ok);


        User user = UserMapper.INSTANCE.toUser(userInfo);
        user.setNew(true);
        System.out.println(user);
//        User savedUser = userService.addUser(user).join();
//        log.info(savedUser.toString());
//        assertEquals(user, savedUser);
//        assertEquals(savedUser.getSocialSet().size(), 3);
//        assertEquals(savedUser.getRoleRefSet().size(), 2);

    }

    @Test
    @Disabled
    public void GetUserWithRoles() {

        User user = userService.getUserByUsernameService("darkneees1").join();
        System.out.println(user);


    }

    @Test
    @Disabled
    public void TestMapperServiceStatus(){
        UserNotFoundException exception = new UserNotFoundException("dark");
        DeleteUserByUsernameResponse response = ResponseMapperException.INSTANCE.toDeleteUserByUsernameResponse(exception);

        System.out.println(response.getStatus().isSuccess());
        System.out.println(response.getStatus().getErrors());
    }

}