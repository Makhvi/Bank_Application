package com.demo.BankingApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.BankingApplication.Entities.Account;
import com.demo.BankingApplication.Entities.Account;
import com.demo.BankingApplication.Repository.AccountRepository;
import com.demo.BankingApplication.Repository.AccountRepository;
import com.demo.BankingApplication.Service.AccountService;
import com.demo.BankingApplication.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService  {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccount(long accountId) {
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Account accountDetails) {
		Account existingAccount = accountRepository.findById(accountDetails.getAccountId())
				.orElseThrow(() -> new RuntimeException("Account not found with id: " + accountDetails.getAccountId()));

		// Update fields of the account
		existingAccount.setAccounttype(accountDetails.getAccounttype());
		existingAccount.setCustomerId(accountDetails.getCustomerId());
		existingAccount.setBalance(accountDetails.getBalance());
		existingAccount.setDateopened(accountDetails.getDateopened());
		// Add other fields as necessary

		return accountRepository.save(existingAccount);
	}

	@Override
	public void deleteAccount(long accountId) {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));

		accountRepository.delete(account);
	}
}
