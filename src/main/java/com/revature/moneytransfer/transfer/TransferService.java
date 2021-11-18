package com.revature.moneytransfer.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    @Autowired
    private TransferRepository repository;

    public Transfer saveTransfer(Transfer transfer) {
        return repository.save(transfer);
    }

    public List<Transfer> getTransfers() {
        return repository.findAll();
    }

    public Transfer getTransferByLocator(String name) {
        return repository.findByLocator(name);
    }

    public String cancelTransfer(int id) {
        repository.deleteById(id);
        return "transfer removed !! " + id;
    }

}