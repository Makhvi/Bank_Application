package com.demo.BankingApplication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.BankingApplication.Entities.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long>{

}
