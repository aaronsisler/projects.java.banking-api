package com.ebsolutions.controller;

import com.ebsolutions.model.Account;
import com.ebsolutions.repository.AccountRepository;
import com.google.gson.Gson;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.ArrayList;

@Controller("/account")
public class AccountController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World";
    }

    @Get(produces = MediaType.APPLICATION_JSON, uri = "/{accountNumber}")
    public HttpResponse<?> getAccount(@PathVariable String accountNumber) {
        try {
            AccountRepository accountRepository = new AccountRepository();
            Account account = accountRepository.getAccount(accountNumber);
            if (account == null) {
            return HttpResponse.notFound();
            }
                return HttpResponse.ok(new Gson().toJson(account));

        } catch (Exception e) {
            return HttpResponse.serverError("Something went wrong: " + e.getMessage());
        }
    }

    @Get(produces = MediaType.APPLICATION_JSON, uri = "/get-all")
    public String getAll() {
        try {
            AccountRepository accountRepository = new AccountRepository();
            ArrayList<Account> accounts = accountRepository.getAccounts();

            return new Gson().toJson(accounts);
        } catch (Exception e) {
            return "get-all threw an exception: " + e;
        }
    }
}