package com.whitecloak.digitalbank.controller;

import com.whitecloak.digitalbank.model.UserEntity;
import com.whitecloak.digitalbank.model.UserFullNameResponse;
import com.whitecloak.digitalbank.service.DigitalBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/bank")
@RestController
public class UserController {

    private DigitalBankService digitalBankService;

    @Autowired
    public UserController(DigitalBankService digitalBankService) {
        this.digitalBankService = digitalBankService;
    }

    @GetMapping("/users/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return digitalBankService.getUser(id);
    }

    @GetMapping("users/fullname/{id}")
    public UserFullNameResponse getFullName(@PathVariable("id") Long id) {
        return digitalBankService.getFullName(id);
    }
}
