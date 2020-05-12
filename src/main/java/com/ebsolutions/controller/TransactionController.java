package com.ebsolutions.controller;

import com.ebsolutions.model.Account;
import com.ebsolutions.model.TransactionRequest;
import com.ebsolutions.repository.AccountRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/transaction")
public class TransactionController {
    @Post(consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<String> createTransaction(@Body TransactionRequest transactionRequest) {
        try {
            System.out.println(transactionRequest.getTransactionType());
            AccountRepository accountRepository = new AccountRepository();
            Account account = accountRepository.getAccount(transactionRequest.getAccount().getAccountNumber());
            System.out.println(account.getAccountNumber());
            return HttpResponse.ok("All good");

        } catch (Exception e) {
            return HttpResponse.serverError("Something went wrong: " + e.getMessage());
        }
    }
}