package com.demo.BankingApplication.Service;

import java.util.List;

import com.demo.BankingApplication.Entities.Customer;


public interface CustomerService {
	public List<Customer> getCustomers(); // Retrieve all Customers
    public Customer getCustomer(long customerId); // Retrieve a single Customer
    public Customer addCustomer(Customer customer); // Add a new Customer
    public Customer updateCustomer(Customer customer); // Update an existing Customer
    public void deleteCustomer(long customerId); // Delete a Customer
}
