package com.whitecloak.digitalbank.repository;

import com.whitecloak.digitalbank.model.UserAccountEntity;
import org.springframework.data.repository.Repository;

public interface UserAccountRepository extends Repository<UserAccountEntity, Long> {

    UserAccountEntity save(UserAccountEntity entity);

    UserAccountEntity findByAccountNumber(Long accountNumber);
}
