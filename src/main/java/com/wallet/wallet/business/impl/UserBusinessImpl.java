package com.wallet.wallet.business.impl;

import java.util.Optional;

import com.wallet.wallet.business.UserBusiness;
import com.wallet.wallet.dbo.model.User;
import com.wallet.wallet.dbo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessImpl implements UserBusiness {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmailEquals(email);
  }

}