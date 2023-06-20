package com.victorvilar.projetoempresa.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<ApplicationUser> applicationUsers = new HashSet<>();


    public Role() {
    }

    public Role(Long id, String roleName, Set<ApplicationUser> applicationUserList) {
        this.id = id;
        this.roleName = roleName;
        this.applicationUsers = applicationUserList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<ApplicationUser> getApplicationUserList() {
        return applicationUsers;
    }

    public void setApplicationUserList(Set<ApplicationUser> applicationUserList) {
        this.applicationUsers = applicationUserList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(roleName, role.roleName) && Objects.equals(applicationUsers, role.applicationUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, applicationUsers);
    }
}
