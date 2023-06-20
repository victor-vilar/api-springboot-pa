package com.victorvilar.projetoempresa.repository;


import com.victorvilar.projetoempresa.domain.ApplicationUser;
import com.victorvilar.projetoempresa.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Long> {

    public ApplicationUser findByUsername(String user);
    public List<ApplicationUser> findByRoles(Role role);

}
