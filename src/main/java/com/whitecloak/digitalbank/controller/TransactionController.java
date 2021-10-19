package com.whitecloak.digitalbank.controller;

import com.whitecloak.digitalbank.model.TransactionEntity;
import com.whitecloak.digitalbank.model.UserAccountResponse;
import com.whitecloak.digitalbank.model.UserEntity;
import com.whitecloak.digitalbank.model.UserFullNameResponse;
import com.whitecloak.digitalbank.service.DigitalBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/bank/transactions")
@RestController
public class TransactionController {

    private DigitalBankService digitalBankService;

    @Autowired
    public TransactionController(DigitalBankService digitalBankService) {
        this.digitalBankService = digitalBankService;
    }

    @PostMapping("")
    public TransactionEntity transact(@RequestBody TransactionEntity newTransaction) {
        return digitalBankService.transact(newTransaction);
    }

    @GetMapping("/{id}")
    public TransactionEntity getTransaction(@PathVariable("id") Long id) {
        return digitalBankService.getTransaction(id);
    }

}
