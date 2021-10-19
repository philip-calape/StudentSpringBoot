package com.whitecloak.digitalbank.repository;

import com.whitecloak.digitalbank.model.UserEntity;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, Long> {

    UserEntity save(UserEntity entity);

    UserEntity findById(Long id);
}
