package com.demo.BankingApplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	private Long accountId;
	private Long amount;
	private String transactiontype;
	private String date;

public Long getTransactionId() {
		return transactionId;
	}
public void setTransactionId(long transactionId) {
	this.transactionId = transactionId;
}


public Long getAccountId() {
	return accountId;
}


public void setAccountId(Long accountId) {
	this.accountId = accountId;
}


public Long getAmount() {
	return amount;
}


public void setAmount(Long amount) {
	this.amount = amount;
}


public String getTransactiontype() {
	return transactiontype;
}


public void setTransactiontype(String transactiontype) {
	this.transactiontype = transactiontype;
}


public String getDate() {
	return date;
}


public void setDate(String date) {
	this.date = date;
}




public Transaction( Long accountId, Long amount, String transactiontype, String date) {
	super();
	//this.transactionId = transactionId;
	this.accountId = accountId;
	this.amount = amount;
	this.transactiontype = transactiontype;
	this.date = date;
}


public Transaction() {
	super();
}


@Override
public String toString() {
	return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", amount=" + amount
			+ ", transactiontype=" + transactiontype + ", date=" + date + "]";
}


}

