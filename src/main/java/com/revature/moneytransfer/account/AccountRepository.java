package com.revature.moneytransfer.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByName(String name);
}
