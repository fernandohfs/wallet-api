package com.wallet.wallet.repository;

import static org.junit.Assert.assertNotNull;

import com.wallet.wallet.dbo.model.User;
import com.wallet.wallet.dbo.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void testSave() {
    User user = User.builder().name("Teste").email("teste@teste.com").password("123456").build();

    User userResponse = userRepository.save(user);

    assertNotNull(userResponse);
  }

}