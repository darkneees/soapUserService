package com.darkneees.soapuserservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "roles")
public class Role implements Persistable<Long> {
    @Id
    private Long id;
    private String nameRole;
    private String prettyNameRole;
    @Transient
    private boolean isNew;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
        isNew = false;
    }

    public Role(Long id, String nameRole, String prettyNameRole, boolean isNew) {
        this.id = id;
        this.nameRole = nameRole;
        this.prettyNameRole = prettyNameRole;
        this.isNew = isNew;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getPrettyNameRole() {
        return prettyNameRole;
    }

    public void setPrettyNameRole(String prettyNameRole) {
        this.prettyNameRole = prettyNameRole;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nameRole='" + nameRole + '\'' +
                ", prettyNameRole='" + prettyNameRole + '\'' +
                ", isNew=" + isNew +
                '}';
    }
}