package com.student1.CRUD.account.dto;

import lombok.Data;

@Data
public class AccountDTO {
    public Long id;
    public String username;
    public String email;
    public String password;
    public Long roleId;
}
