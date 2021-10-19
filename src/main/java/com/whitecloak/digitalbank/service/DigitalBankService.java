package com.whitecloak.digitalbank.service;

import com.whitecloak.digitalbank.model.TransactionEntity;
import com.whitecloak.digitalbank.model.UserAccountResponse;
import com.whitecloak.digitalbank.model.UserEntity;
import com.whitecloak.digitalbank.model.UserFullNameResponse;

public interface DigitalBankService {
    UserAccountResponse register(UserEntity newUser);
    UserEntity getUser(Long id);
    UserAccountResponse getAccountDetails(Long accountNumber);
    UserFullNameResponse getFullName(Long id);
    TransactionEntity getTransaction(Long id);
    TransactionEntity transact(TransactionEntity newTransaction);
}
