package com.demo.BankingApplication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.BankingApplication.Entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
