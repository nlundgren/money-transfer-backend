package com.revature.moneytransfer.controller;
import com.revature.moneytransfer.entity.Transfer;
import com.revature.moneytransfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "*")
@RestController
public class TransferController {

    @Autowired
    private TransferService service;

    @PostMapping("/transfer")
    public Transfer addTransfer(@RequestBody Transfer transfer) {
        return service.saveTransfer(transfer);
    }

    @GetMapping("/transfers")
    public List<Transfer> findAllTransfers() {
        return service.getTransfers();
    }

    @GetMapping("/transfer/{fromId}")
    public List<Transfer> findByAccount(@PathVariable int fromId) {
        return service.getTransfersByUser(fromId);
    }

    @DeleteMapping("/deleteTransfer/{id}")
    public String deleteTransfer(@PathVariable int id) {
        return service.deleteTransfer(id);
    }
}
