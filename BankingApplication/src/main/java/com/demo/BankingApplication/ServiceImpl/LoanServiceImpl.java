package com.demo.BankingApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.BankingApplication.Entities.Loan;
import com.demo.BankingApplication.Repository.LoanRepository;
import com.demo.BankingApplication.Service.LoanService;
import com.demo.BankingApplication.Service.LoanService;


@Service
public class LoanServiceImpl implements LoanService{
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public List<Loan> getLoans() {
		return loanRepository.findAll();
	}

	@Override
	public Loan getLoan(long loanId) {
		return loanRepository.findById(loanId)
				.orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));
	}

	@Override
	public Loan addLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	@Override
	public Loan updateLoan(Loan loanDetails) {
		Loan existingLoan = loanRepository.findById(loanDetails.getLoanId())
				.orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanDetails.getLoanId()));

		// Update fields of the loan
		existingLoan.setAccountId(loanDetails.getAccountId());
		existingLoan.setInterestrate(loanDetails.getInterestrate());
		existingLoan.setAmount(loanDetails.getAmount());
		existingLoan.setLoantype(loanDetails.getLoantype());
		existingLoan.setDateissued(loanDetails.getDateissued());
		// Add other fields as necessary

		return loanRepository.save(existingLoan);
	}

	@Override
	public void deleteLoan(long loanId) {
		Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));

		loanRepository.delete(loan);
	}
}
