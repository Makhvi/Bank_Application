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

import com.demo.BankingApplication.Entities.Loan;
import com.demo.BankingApplication.Service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

	@Autowired
    private LoanService loanService;

    // Create a new Loan
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
    	Loan savedLoan = loanService.addLoan(loan);
        return ResponseEntity.ok(savedLoan);
    }

    // Get all Loans
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getLoans();
        return ResponseEntity.ok(loans);
    }

    // Get a loan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
    	Loan loan= loanService.getLoan(id);
        return ResponseEntity.ok(loan);
    }

    // Update a Loan
    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {
    	loanDetails.setLoanId(id); // Set the ID to ensure the correct entity is updated
    	Loan updatedLoan = loanService.updateLoan(loanDetails);
        return ResponseEntity.ok(updatedLoan);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
    	loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
