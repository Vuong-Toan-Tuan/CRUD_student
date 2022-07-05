package com.student1.CRUD.account.repository;

import com.student1.CRUD.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
