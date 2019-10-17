package com.wallet.wallet.business;

import java.util.Optional;

import com.wallet.wallet.dbo.model.User;

public interface UserBusiness {

  User create(User user);

  Optional<User> findByEmail(String email);

}