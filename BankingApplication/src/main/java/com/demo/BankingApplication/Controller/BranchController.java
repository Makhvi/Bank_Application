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

import com.demo.BankingApplication.Entities.Branch;
import com.demo.BankingApplication.Service.BranchService;


@RestController
@RequestMapping("/api/branchs")
public class BranchController {

	@Autowired
    private BranchService branchService;

    // Create a new Branch
    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
        Branch savedBranch= branchService.addBranch(branch);
        return ResponseEntity.ok(savedBranch);
    }

    // Get all Branch
    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranchs() {
        List<Branch> branchs = branchService.getBranchs();
        return ResponseEntity.ok(branchs);
    }

    // Get a branch by ID
    @GetMapping("/{id}")
    public ResponseEntity<Branch> getCustomerById(@PathVariable Long id) {
        Branch branch= branchService.getBranch(id);
        return ResponseEntity.ok(branch);
    }

    // Update a Branch
    @PutMapping("/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branchDetails) {
    	branchDetails.setBranchId(id); // Set the ID to ensure the correct entity is updated
        Branch updatedBranch= branchService.updateBranch(branchDetails);
        return ResponseEntity.ok(updatedBranch);
    }

    // Delete a Branch
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
    	branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
