package com.student1.CRUD.account.repository;

import com.student1.CRUD.account.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
