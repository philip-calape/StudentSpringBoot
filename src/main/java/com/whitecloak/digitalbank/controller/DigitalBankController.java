package com.whitecloak.digitalbank.controller;

import com.whitecloak.digitalbank.model.UserAccountResponse;
import com.whitecloak.digitalbank.model.UserEntity;
import com.whitecloak.digitalbank.service.DigitalBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class DigitalBankController {

    private DigitalBankService digitalBankService;

    @Autowired
    public DigitalBankController(DigitalBankService digitalBankService) {
        this.digitalBankService = digitalBankService;
    }

    @PostMapping("/accounts")
    public UserAccountResponse register(@RequestBody UserEntity newUser) {
        return digitalBankService.register(newUser);
    }

    @GetMapping("/accounts")
    public String print() {
        return "Hello World";
    }

    @GetMapping("/accounts/{accountNumber}")
    public UserAccountResponse getAccountDetails(@PathVariable("accountNumber") Long accountNumber) {
        return digitalBankService.getAccountDetails(accountNumber);
    }
}
