package com.demo.BankingApplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;
	private Long accountId;
	private Long interestrate;
	private String amount;
	private String loantype;
	private String dateissued; // Can be a JSON string or array if not yet mapped to a Comment entity
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(Long interestrate) {
		this.interestrate = interestrate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getLoantype() {
		return loantype;
	}
	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}
	public String getDateissued() {
		return dateissued;
	}
	public void setDateissued(String dateissued) {
		this.dateissued = dateissued;
	}
	public Loan( Long accountId, Long interestrate, String amount, String loantype, String dateissued) {
		super();
		//this.loanId = loanId;
		this.accountId = accountId;
		this.interestrate = interestrate;
		this.amount = amount;
		this.loantype = loantype;
		this.dateissued = dateissued;
	}

	public Loan() {
		super();
		// Default constructor
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", accountId=" + accountId + ", interestrate=" + interestrate + ", amount="
				+ amount + ", loantype=" + loantype + ", dateissued=" + dateissued + "]";
	}
	
	
}
