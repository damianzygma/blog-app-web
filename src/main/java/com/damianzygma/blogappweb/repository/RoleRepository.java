package com.damianzygma.blogappweb.repository;

import com.damianzygma.blogappweb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
