package com.revature.moneytransfer.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TransferRepository extends JpaRepository<Transfer,Integer> {
    @Query(value = "SELECT * FROM TRANSFERS WHERE FROM_ID = ?1", nativeQuery = true)
    List<Transfer> getTransfersByAccount(int fromId);
}
