package com.revature.moneytransfer.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public List<Account> saveAccounts(List<Account> accounts) {
        return repository.saveAll(accounts);
    }

    public List<Account> getAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Account getAccountByName(String name) {
        return repository.findByName(name);
    }

    public String deleteAccount(int id) {
        repository.deleteById(id);
        return "account removed !! " + id;
    }

    public Account updateAccount(Account account) {
        Account existingAccount = repository.findById(account.getId()).orElse(null);
        existingAccount.setFirstName(account.getFirstName());
        existingAccount.setLastName(account.getLastName());
        existingAccount.setBalance(account.getBalance());
        existingAccount.setType(account.getType());
        return repository.save(existingAccount);
    }
}
