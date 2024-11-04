package com.demo.BankingApplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long branchId;
	private String branchname;
	private String phonenumber;
	private String address;
	public long getBranchId() {
		return branchId;
	}
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
	public String setBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String setPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Branch( String branchname, String phonenumber, String address) {
		super();
//		this.branchId = branchId;
		this.branchname = branchname;
		this.phonenumber = phonenumber;
		this.address = address;
	}

	public Branch() {
		super();
		// Default constructor
	}
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchname=" + branchname + ", phonenumber=" + phonenumber
				+ ", address=" + address + "]";
	}
	
}
