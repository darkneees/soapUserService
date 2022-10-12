package com.darkneees.soapuserservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "users")
public class User implements Persistable<String> {

    @Id
    private String username;
    private String firstName;
    private String secondName;
    private int age;
    private String password;
    @Transient
    private boolean isNew;

    @Transient
    private Set<Role> roleSet = new HashSet<>();

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @MappedCollection(keyColumn = "username", idColumn = "username")
    Set<Social> socialSet = new HashSet<>();

    @MappedCollection(idColumn = "username")
    private Set<RoleRef> roleRefSet = new HashSet<>();


    public User() {
    }

    public User(String username, String firstName, String secondName, int age, String password, boolean isNew) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.password = password;
        this.isNew = isNew;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Set<Social> getSocialSet() {
        return socialSet;
    }

    public void setSocialSet(Set<Social> socialSet) {
        this.socialSet = socialSet;
    }

    public Set<RoleRef> getRoleRefSet() {
        return roleRefSet;
    }

    public void setRoleRefSet(Set<RoleRef> roleRefSet) {
        this.roleRefSet = roleRefSet;
    }

    public void addSocial(Social s) {
        this.socialSet.add(s);
    }

    public void addRoleRef(Role r1) {
        this.roleRefSet.add(new RoleRef(r1.getId()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String getId() {
        return username;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", isNew=" + isNew +
                ", roleSet=" + roleSet +
                ", socialSet=" + socialSet +
                ", roleRefSet=" + roleRefSet +
                '}';
    }
}