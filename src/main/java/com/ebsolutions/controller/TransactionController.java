package com.ebsolutions.controller;

import com.ebsolutions.model.Account;
import com.ebsolutions.repository.AccountRepository;
import com.google.gson.Gson;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import java.util.ArrayList;

@Controller("/transaction")
public class TransactionController {
    @Post(produces = MediaType.APPLICATION_JSON, uri = "/{accountNumber}")
    public HttpResponse<String> createTransaction(@PathVariable String accountNumber) {
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
    public HttpResponse<String> getAll() {
        try {
            AccountRepository accountRepository = new AccountRepository();
            ArrayList<Account> accounts = accountRepository.getAccounts();

            return HttpResponse.ok(new Gson().toJson(accounts));
        } catch (Exception e) {
            return HttpResponse.serverError("Something went wrong: " + e.getMessage());
        }
    }
}