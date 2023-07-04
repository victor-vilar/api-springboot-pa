package com.victorvilar.projetoempresa.repository;


import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Long> {

    public Optional<ApplicationUser> findByUsername(String user);
    public List<ApplicationUser> findByApplicationUserRoles(ApplicationUserRole applicationUserRole);

}
