package com.victorvilar.projetoempresa.repository;

import com.victorvilar.projetoempresa.domain.ApplicationUser;
import com.victorvilar.projetoempresa.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesRepository extends JpaRepository<Role,Long> {

    List<Role> findByApplicationUsers(ApplicationUser user);
    Role findByRoleName(String role);

}
