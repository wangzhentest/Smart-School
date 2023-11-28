package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

}
