package com.revature.moneytransfer.transfer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Integer> {
    Transfer findByLocator(String locator);
}
