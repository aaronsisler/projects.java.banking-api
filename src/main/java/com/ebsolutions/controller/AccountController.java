package com.ebsolutions.controller;

import com.ebsolutions.model.Account;
import com.ebsolutions.repository.AccountRepository;
import com.google.gson.Gson;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.ArrayList;

@Controller("/account")
public class AccountController {

    private final AccountRepository accountRepository = new AccountRepository();

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World";
    }

    @Get(produces = MediaType.APPLICATION_JSON, uri = "/get-all")
    public String getAll() {
        try {
            ArrayList<Account> accounts = this.accountRepository.getAccounts();
            
            return new Gson().toJson(accounts);
        } catch (Exception e) {
            return "get-all threw an exception: " + e;
        }
    }
}