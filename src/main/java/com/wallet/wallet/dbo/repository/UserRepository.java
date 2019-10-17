package com.wallet.wallet.dbo.repository;

import java.util.Optional;

import com.wallet.wallet.dbo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmailEquals(String email);

}