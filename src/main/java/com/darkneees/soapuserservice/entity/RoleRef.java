package com.darkneees.soapuserservice.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table(name = "users_roles")
public class RoleRef {

    Long roleId;

    public RoleRef() {
    }

    public Long getId() {
        return roleId;
    }

    public void setId(Long id) {
        this.roleId = id;
    }

    public RoleRef(Long id) {
        this.roleId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleRef ref = (RoleRef) o;
        return Objects.equals(roleId, ref.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }

    @Override
    public String toString() {
        return "RoleRef{" +
                "roleId=" + roleId +
                '}';
    }
}