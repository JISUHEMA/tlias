package com.eden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eden.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
