package com.example.money.repository;

import com.example.money.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByName(String name);
    Account findByUserEmail(String userEmail);
    Optional<Account> findByUserEmailAndName(String userEmail, String name);

}
