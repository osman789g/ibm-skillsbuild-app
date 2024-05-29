package com.example.newone.repos;

import com.example.newone.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
