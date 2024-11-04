package com.demo.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.BankingApplication.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}


