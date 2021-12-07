package com.revature.moneytransfer.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.moneytransfer.account.AccountService;
import com.revature.moneytransfer.account.Account;

import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepository repository;

    @Autowired
    private AccountService accountService;



    public Transfer saveTransfer(Transfer transfer) {


        Account fromAccount  = accountService.getAccountById(transfer.getFromId());
        fromAccount.setBalance(fromAccount.getBalance() - transfer.getAmount());
        accountService.saveAccount(fromAccount);

        Account toAccount = accountService.getAccountById(transfer.getToId());
        toAccount.setBalance(toAccount.getBalance() + transfer.getAmount());
        accountService.saveAccount(toAccount);
        return repository.save(transfer);
    }

    public List<Transfer> getTransfers() {
        return repository.findAll();
    }

    public List<Transfer> getTransfersByAccount(int fromId) { return repository.getTransfersByAccount(fromId);}


    public String deleteTransfer(int id) {
        repository.deleteById(id);
        return "transfer removed !! " + id;
    }

}