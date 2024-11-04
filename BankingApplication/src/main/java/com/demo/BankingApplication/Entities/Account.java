package com.demo.BankingApplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private Long customerId;
	private String accounttype;
	private String balance;
	private String dateopened; // Can be a JSON string or array if not yet mapped to a Comment entity
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getDateopened() {
		return dateopened;
	}
	public void setDateopened(String dateopened) {
		this.dateopened = dateopened;
	}
	public Account( Long customerId, String accounttype, String balance, String dateopened) {
		super();
		//this.accountId = accountId;
		this.customerId = customerId;
		this.accounttype = accounttype;
		this.balance = balance;
		this.dateopened = dateopened;
	}

	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerId=" + customerId + ", accounttype=" + accounttype
				+ ", balance=" + balance + ", dateopened=" + dateopened + "]";
	}
	
	
}
