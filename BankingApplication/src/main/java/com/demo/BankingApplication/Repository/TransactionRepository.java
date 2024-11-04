package com.demo.BankingApplication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.BankingApplication.Entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
