package com.victorvilar.projetoempresa.domain.applicationuser;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="roles")
public class ApplicationUserRole implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @ManyToMany(mappedBy = "applicationUserRoles")
    private Set<ApplicationUser> applicationUsers = new HashSet<>();


    public ApplicationUserRole() {
    }

    public ApplicationUserRole(Long id, String roleName, Set<ApplicationUser> applicationUserList) {
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

    @Override
    public String getAuthority() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName(){return this.roleName;}

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
        ApplicationUserRole applicationUserRole = (ApplicationUserRole) o;
        return Objects.equals(id, applicationUserRole.id) && Objects.equals(roleName, applicationUserRole.roleName) && Objects.equals(applicationUsers, applicationUserRole.applicationUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, applicationUsers);
    }


}
