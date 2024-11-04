package com.demo.BankingApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.BankingApplication.Entities.Transaction;
import com.demo.BankingApplication.Repository.TransactionRepository;
import com.demo.BankingApplication.Service.TransactionService;
import com.demo.BankingApplication.Service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction getTransaction(long transactionId) {
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new RuntimeException("Transaction not found with id: " + transactionId));
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction updateTransaction(Transaction transactionDetails) {
		Transaction existingTransaction = transactionRepository.findById(transactionDetails.getTransactionId())
				.orElseThrow(() -> new RuntimeException("Transaction not found with id: " + transactionDetails.getTransactionId()));

		// Update fields of the transaction
		existingTransaction.setAccountId(transactionDetails.getAccountId());
		existingTransaction.setAmount(transactionDetails.getAmount());
		existingTransaction.setTransactiontype(transactionDetails.getTransactiontype());
		existingTransaction.setDate(transactionDetails.getDate());
		// Add other fields as necessary

		return transactionRepository.save(existingTransaction);
	}

	@Override
	public void deleteTransaction(long transactionId) {
		Transaction transaction = transactionRepository.findById(transactionId)
				.orElseThrow(() -> new RuntimeException("Transaction not found with id: " + transactionId));

		transactionRepository.delete(transaction);
	}
}
