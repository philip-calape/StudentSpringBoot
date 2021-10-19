package com.whitecloak.digitalbank.service;

import com.whitecloak.digitalbank.model.*;
import com.whitecloak.digitalbank.repository.TransactionRepository;
import com.whitecloak.digitalbank.repository.UserAccountRepository;
import com.whitecloak.digitalbank.repository.UserRepository;
import com.whitecloak.digitalbank.util.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Service
public class DigitalBankServiceImpl implements DigitalBankService {

    private final UserRepository userRepository;
    private final UserAccountRepository userAccountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public DigitalBankServiceImpl(UserRepository userRepository,
            UserAccountRepository userAccountRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.userAccountRepository = userAccountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public UserAccountResponse register(UserEntity newUser) {
        UserEntity newUserEntity = userRepository.save(newUser);
        UserAccountEntity accountEntity = openNewAccount(newUserEntity);
        return new UserAccountResponse(accountEntity.getUserEntity().getId(),
                accountEntity.getAccountNumber(), accountEntity.getBalance());
    }

    @Override
    public TransactionEntity transact(TransactionEntity newTransaction) {;
        UserAccountEntity sourceAccount = userAccountRepository.findByAccountNumber(newTransaction.getSourceAccount());
        UserAccountEntity targetAccount = userAccountRepository.findByAccountNumber(newTransaction.getTargetAccount());
        newTransaction.setEndingBalance(sourceAccount.getBalance().subtract(newTransaction.getAmount()));
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(newTransaction.getAmount()));
        targetAccount.setBalance(targetAccount.getBalance().add(newTransaction.getAmount()));
        TransactionEntity newTransactionEntity = transactionRepository.save(newTransaction);
        userAccountRepository.save(sourceAccount);
        userAccountRepository.save(targetAccount);
        return newTransactionEntity;
    }

    @Override
    public TransactionEntity getTransaction(Long id) {
        TransactionEntity transaction = transactionRepository.findById(id);

        if (ObjectUtils.isEmpty(transaction)) {
            //Should throw error
            System.out.println("transaction not found");
        }
        return transaction;
    }

    @Override
    public UserEntity getUser(Long id) {
        UserEntity user = userRepository.findById(id);

        if (ObjectUtils.isEmpty(user)) {
            //Should throw error
            System.out.println("user not found");
        }
        return userRepository.findById(id);
    }

    @Override
    public UserFullNameResponse getFullName(Long id) {
        UserEntity user = userRepository.findById(id);

        if (ObjectUtils.isEmpty(user)) {
            //Should throw error
            System.out.println("user not found");
        }

        String userFullName = user.getFirstName() + " " + user.getLastName();
        UserFullNameResponse output = new UserFullNameResponse(userFullName);

        return output;
    }

    @Override
    public UserAccountResponse getAccountDetails(Long accountNumber) {
        UserAccountEntity accountEntity = userAccountRepository.findByAccountNumber(accountNumber);

        if (ObjectUtils.isEmpty(accountEntity)) {
            //Should throw error
            return null;
        }

        return new UserAccountResponse(accountEntity.getUserEntity().getId(),
                accountEntity.getAccountNumber(), accountEntity.getBalance());
    }

    private UserAccountEntity openNewAccount(UserEntity newUserEntity) {
        return saveUserAccount(newUserEntity);
    }

    private UserAccountEntity saveUserAccount(UserEntity newUserEntity) {
        Long accountNumber = null;
        boolean accountExisting = true;

        while (accountExisting) {
            accountNumber = AccountUtils.generateAccountNumber();
            if (userAccountRepository.findByAccountNumber(accountNumber) == null) {
                accountExisting = false;
            }
        }

        return userAccountRepository.save(
                new UserAccountEntity(null, newUserEntity, accountNumber,
                        new BigDecimal(1000)));
    }
}
