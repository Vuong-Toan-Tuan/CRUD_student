package com.student1.CRUD.account.service;

import com.student1.CRUD.account.dto.AccountDTO;

public interface AccountService {
    String createAccount(AccountDTO newAcc);
    AccountDTO findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    void loadAccountByUsername(String username);
}
