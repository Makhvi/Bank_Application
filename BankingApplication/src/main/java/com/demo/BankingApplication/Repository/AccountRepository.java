package com.demo.BankingApplication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.BankingApplication.Entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
