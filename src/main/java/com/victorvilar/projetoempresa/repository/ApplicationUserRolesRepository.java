package com.victorvilar.projetoempresa.repository;

import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationUserRolesRepository extends JpaRepository<ApplicationUserRole,Long> {

    List<ApplicationUserRole> findByApplicationUsers(ApplicationUser user);
    ApplicationUserRole findByRoleName(String role);

}
