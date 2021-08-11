package com.example.demo.service.Impl;

import com.example.demo.bean.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(Integer id){
        return accountMapper.getAcct(id);
    }

}
