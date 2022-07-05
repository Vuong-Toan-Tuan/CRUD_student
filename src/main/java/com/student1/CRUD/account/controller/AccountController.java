package com.student1.CRUD.account.controller;

import com.student1.CRUD.account.dto.AccountDTO;
import com.student1.CRUD.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public void create(@RequestBody AccountDTO newAcc){
        accountService.createAccount(newAcc);
    }
}
