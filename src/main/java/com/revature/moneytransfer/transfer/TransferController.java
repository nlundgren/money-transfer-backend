package com.revature.moneytransfer.transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransferController {

    @Autowired
    private TransferService service;

    @PostMapping("/addTransfer")
    public Transfer addTransfer(@RequestBody Transfer transfer) {
        return service.saveTransfer(transfer);
    }

    @GetMapping("/transfers")
    public List<Transfer> findAllTransfers() {
        return service.getTransfers();
    }

    @GetMapping("/transfer/{locator}")
    public Transfer findTransferByLocator(@PathVariable String locator) {
        return service.getTransferByLocator(locator);
    }

    @DeleteMapping("/delete/{id}")
    public String cancelTransfer(@PathVariable int id) {
        return service.cancelTransfer(id);
    }
}
