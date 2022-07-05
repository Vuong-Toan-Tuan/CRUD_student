package com.student1.CRUD.account.service.impl;

import com.student1.CRUD.account.dto.AccountDTO;
import com.student1.CRUD.account.entity.Account;
import com.student1.CRUD.account.repository.AccountRepository;
import com.student1.CRUD.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Throwable.class)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public String createAccount(AccountDTO newAcc) {
//        @Autowired
        ModelMapper modelMapper = new ModelMapper();
        Account accountEntity = modelMapper.map(newAcc, Account.class);
        accountRepository.save(accountEntity);
        return "Success";
    }

    @Override
    public AccountDTO findByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    @Transactional
    public void loadAccountByUsername(String username) {
        AccountDTO accountDto = this.findByUsername(username);
        if(accountDto == null){

        }
//        return AccountServiceImpl.build(accountDto);
    }
}
