package com.revature.moneytransfer.service;

import com.revature.moneytransfer.entity.Transfer;
import com.revature.moneytransfer.entity.User;
import com.revature.moneytransfer.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepository repository;

    @Autowired
    private UserServiceImpl userService;


    public Transfer saveTransfer(Transfer transfer) {


        User fromUser  = userService.getUserById(transfer.getFromId());
        fromUser.setBalance(fromUser.getBalance() - transfer.getAmount());
        userService.saveUser(fromUser);

        User toUser = userService.getUserById(transfer.getToId());
        toUser.setBalance(toUser.getBalance() + transfer.getAmount());
        userService.saveUser(toUser);
        return repository.save(transfer);
    }

    public List<Transfer> getTransfers() {
        return repository.findAll();
    }

    public List<Transfer> getTransfersByUser(int fromId) { return repository.getTransfersByUser(fromId);}


    public String deleteTransfer(int id) {
        repository.deleteById(id);
        return "transfer removed !! " + id;
    }

}
