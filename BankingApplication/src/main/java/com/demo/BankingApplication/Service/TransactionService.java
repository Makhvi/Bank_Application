package com.demo.BankingApplication.Service;

import java.util.List;


import com.demo.BankingApplication.Entities.Transaction;

public interface TransactionService {
	public List<Transaction> getTransactions(); // Retrieve all Transactions
    public Transaction getTransaction(long transactionId); // Retrieve a single Transaction
    public Transaction addTransaction(Transaction transaction); // Add a new Transaction
    public Transaction updateTransaction(Transaction transaction); // Update an existing Transaction
    public void deleteTransaction(long transactionId); // Delete a Transaction
}
