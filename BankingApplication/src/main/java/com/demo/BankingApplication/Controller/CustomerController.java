package com.demo.BankingApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.BankingApplication.Entities.Customer;
import com.demo.BankingApplication.Service.CustomerService;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	 @Autowired
	    private CustomerService customerService;

	    // Create a new customer
	    @PostMapping
	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	        Customer savedCustomer = customerService.addCustomer(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }

	    // Get all customers
	    @GetMapping
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> customers = customerService.getCustomers();
	        return ResponseEntity.ok(customers);
	    }

	    // Get a customer by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
	        Customer customer = customerService.getCustomer(id);
	        return ResponseEntity.ok(customer);
	    }

	    // Update a customer
	    @PutMapping("/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
	        customerDetails.setCustomerId(id); // Set the ID to ensure the correct entity is updated
	        Customer updatedCustomer = customerService.updateCustomer(customerDetails);
	        return ResponseEntity.ok(updatedCustomer);
	    }

	    // Delete a customer
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
	        customerService.deleteCustomer(id);
	        return ResponseEntity.noContent().build();
	    }
}
