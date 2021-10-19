package com.whitecloak.digitalbank.repository;

import com.whitecloak.digitalbank.model.TransactionEntity;
import org.springframework.data.repository.Repository;

public interface TransactionRepository extends Repository<TransactionEntity, Long> {

    TransactionEntity save(TransactionEntity entity);

    TransactionEntity findById(Long id);
}
