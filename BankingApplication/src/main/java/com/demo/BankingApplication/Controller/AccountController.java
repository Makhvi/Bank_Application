package com.demo.BankingApplication.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.BankingApplication.Entities.Account;
import com.demo.BankingApplication.Service.AccountService;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
    private AccountService accountService;

    // Create a new Account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount= accountService.addAccount(account);
        return ResponseEntity.ok(savedAccount);
    }

    // Get all Accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Get a account by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account= accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }

    // Update a Account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
    	accountDetails.setCustomerId(id); // Set the ID to ensure the correct entity is updated
        Account updatedAccount= accountService.updateAccount(accountDetails);
        return ResponseEntity.ok(updatedAccount);
    }

    // Delete a Account
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
    	accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
