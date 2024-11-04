package com.demo.BankingApplication.Service;

import java.util.List;

import com.demo.BankingApplication.Entities.Account;



public interface AccountService {
	public List<Account> getAccounts(); // Retrieve all Accounts
    public Account getAccount(long accountId); // Retrieve a single Account
    public Account addAccount(Account account); // Add a new Account
    public Account updateAccount(Account account); // Update an existing Account
    public void deleteAccount(long accountId); // Delete a Account

}
