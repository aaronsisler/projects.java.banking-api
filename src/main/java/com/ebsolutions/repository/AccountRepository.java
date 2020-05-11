package com.ebsolutions.repository;

import com.ebsolutions.model.Account;
import com.ebsolutions.service.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountRepository implements IAccountRepository {
    private final DatabaseService databaseService = new DatabaseService();

    public ArrayList<Account> getAccounts() throws Exception {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            Statement statement = databaseService.getStatement();

            ResultSet resultSet = statement
                    .executeQuery("select * from Banking.account;");

            while (resultSet.next()) {
                Account account = getAccount(resultSet);
                accounts.add(account);
            }
            databaseService.closeResultSet(resultSet);

            return accounts;
        } finally {
            databaseService.close();
        }

    }

    @Override
    public Account getAccount(String accountNumberParam) throws Exception {
        try {
            String query = "SELECT * FROM Banking.account WHERE accountNumber = ?;";
            PreparedStatement preparedStatement = databaseService.getPreparedStatement(query);

            preparedStatement.setString(1, accountNumberParam);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
//            if (resultSet.first()) {
                Account account = getAccount(resultSet);
                databaseService.closeResultSet(resultSet);
                return account;
//            }

//            return null;


        } finally {
            databaseService.close();
        }
    }

    @Override
    public Account saveAccount(Account account) {
        return null;
    }

    private Account getAccount(ResultSet resultSet) throws Exception {
        String accountNumber = resultSet.getString("accountNumber");
        String accountOwner = resultSet.getString("accountOwner");
        int accountId = resultSet.getInt("accountId");
        return new Account(accountId, accountNumber, accountOwner, 0);
    }
}
