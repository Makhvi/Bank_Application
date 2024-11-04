package com.demo.BankingApplication.Service;

import java.util.List;

import com.demo.BankingApplication.Entities.Loan;

public interface LoanService {
	public List<Loan> getLoans(); // Retrieve all Loans
    public Loan getLoan(long loanId); // Retrieve a single Loan
    public Loan addLoan(Loan loan); // Add a new Loan
    public Loan updateLoan(Loan loan); // Update an existing Loan
    public void deleteLoan(long loanId); // Delete a Loan
}
