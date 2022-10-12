package com.darkneees.soapuserservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "socials")
public class Social {

    @Id
    private Long id;
    private String username;
    private String nameSocial;
    private String identifierSocial;

    public Social() {
    }

    public Social(String identifierSocial) {
        this.identifierSocial = identifierSocial;
    }

    public Social(String nameSocial, String identifierSocial) {
        this.nameSocial = nameSocial;
        this.identifierSocial = identifierSocial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameSocial() {
        return nameSocial;
    }

    public void setNameSocial(String nameSocial) {
        this.nameSocial = nameSocial;
    }

    public String getIdentifierSocial() {
        return identifierSocial;
    }

    public void setIdentifierSocial(String identifierSocial) {
        this.identifierSocial = identifierSocial;
    }



    @Override
    public String toString() {
        return "Social{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nameSocial='" + nameSocial + '\'' +
                ", identifierSocial='" + identifierSocial + '\'' +
                '}';
    }
}