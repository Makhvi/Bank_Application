package com.demo.BankingApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.BankingApplication.Entities.Customer;

import com.demo.BankingApplication.Repository.CustomerRepository;
import com.demo.BankingApplication.Service.CustomerService;




@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(long customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customerDetails) {
		Customer existingCustomer = customerRepository.findById(customerDetails.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerDetails.getCustomerId()));

		// Update fields of the customer
		existingCustomer.setName(customerDetails.getName());
		existingCustomer.setEmail(customerDetails.getEmail());
		existingCustomer.setAddress(customerDetails.getAddress());
		existingCustomer.setDateofbirth(customerDetails.getDateofbirth());
		// Add other fields as necessary

		return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteCustomer(long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

		customerRepository.delete(customer);
	}
}
