package com.revature.moneytransfer.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account account) {
        return service.saveAccount(account);
    }

    @PostMapping("/addAccounts")
    public List<Account> addAccounts(@RequestBody List<Account> accounts) {
        return service.saveAccounts(accounts);
    }

    @GetMapping("/accounts")
    public List<Account> findAllAccounts() {
        return service.getAccounts();
    }

    @GetMapping("/accountById/{id}")
    public Account findAccountById(@PathVariable int id) {
        return service.getAccountById(id);
    }

    @GetMapping("/account/{name}")
    public Account findAccountByName(@PathVariable String name) {
        return service.getAccountByName(name);
    }

    @PutMapping("/update")
    public Account updateAccount(@RequestBody Account account) {
        return service.updateAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        return service.deleteAccount(id);
    }
}
