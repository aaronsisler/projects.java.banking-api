package com.ebsolutions.repository;

import com.ebsolutions.model.Account;
import com.ebsolutions.service.DatabaseService;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountRepository implements IAccountRepository {
    public ArrayList<Account> getAccounts() throws Exception {
        DatabaseService databaseService = new DatabaseService();
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            Statement statement = databaseService.getStatement();

            ResultSet resultSet = statement
                    .executeQuery("select * from Banking.account");

            while (resultSet.next()) {
                String accountNumber = resultSet.getString("accountNumber");
                String accountOwner = resultSet.getString("accountOwner");
                int accountId = resultSet.getInt("accountId");
                Account account = new Account(accountId, accountNumber, accountOwner, 0);
                accounts.add(account);
            }
            databaseService.closeResultSet(resultSet);

            return accounts;
        } finally {
            databaseService.close();
        }

    }

    @Override
    public Account getAccount(String accountNumber) {
        return null;
    }

    @Override
    public Account saveAccount(Account account) {
        return null;
    }
}
