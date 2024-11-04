package com.demo.BankingApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.BankingApplication.Entities.Branch;
import com.demo.BankingApplication.Repository.BranchRepository;
import com.demo.BankingApplication.Service.BranchService;
import com.demo.BankingApplication.Service.BranchService;


@Service
public class BranchServiceImpl implements BranchService  {
	@Autowired
		private BranchRepository branchRepository;

		@Override
		public List<Branch> getBranchs() {
			return branchRepository.findAll();
		}

		@Override
		public Branch getBranch(long branchId) {
			return branchRepository.findById(branchId)
					.orElseThrow(() -> new RuntimeException("Branch not found with id: " + branchId));
		}

		@Override
		public Branch addBranch(Branch branch) {
			return branchRepository.save(branch);
		}

		@Override
		public Branch updateBranch(Branch branchDetails) {
			Branch existingBranch = branchRepository.findById(branchDetails.getBranchId())
					.orElseThrow(() -> new RuntimeException("Branch not found with id: " + branchDetails.getBranchId()));

			// Update fields of the branch
			existingBranch.setBranchname(branchDetails.setBranchname());
			existingBranch.setPhonenumber(branchDetails.setPhonenumber());
			existingBranch.setAddress(branchDetails.getAddress());
		
			// Add other fields as necessary

			return branchRepository.save(existingBranch);
		}

		@Override
		public void deleteBranch(long branchId) {
			Branch branch = branchRepository.findById(branchId)
					.orElseThrow(() -> new RuntimeException("Branch not found with id: " + branchId));

			branchRepository.delete(branch);
		}
	}

