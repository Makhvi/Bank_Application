package com.demo.BankingApplication.Service;

import java.util.List;


import com.demo.BankingApplication.Entities.Branch;

public interface BranchService {
	public List<Branch> getBranchs(); // Retrieve all Branches
    public Branch getBranch(long branchId); // Retrieve a single Branch
    public Branch addBranch(Branch branch); // Add a new Branch
    public Branch updateBranch(Branch branch); // Update an existing Branch
    public void deleteBranch(long branchId); // Delete a Branch

}
