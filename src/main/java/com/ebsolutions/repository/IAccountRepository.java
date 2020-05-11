package com.ebsolutions.repository;

import com.ebsolutions.model.Account;

public interface IAccountRepository {
    Account getAccount(String accountNumber);

    Account saveAccount(Account account);
}
