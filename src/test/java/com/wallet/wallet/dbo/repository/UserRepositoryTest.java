package com.wallet.wallet.dbo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.wallet.wallet.dbo.model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

  private static final String EMAIL_TEST = "fernando.soares@luizalabs.com";

  @Autowired
  UserRepository userRepository;

  @Before
  public void setUp() {
    User user = User.builder().name("Fernando").email(EMAIL_TEST).password("123456").build();

    userRepository.save(user);
  }

  @After
  public void tearDown() {
    userRepository.deleteAll();
  }

  @Test
  public void testSave() {
    User user = User.builder().name("Teste").email("teste@teste.com").password("123456").build();

    User userResponse = userRepository.save(user);

    assertNotNull(userResponse);
  }

  @Test
  public void testFindByEmail() {
    Optional<User> userResponse = userRepository.findByEmailEquals(EMAIL_TEST);

    assertTrue(userResponse.isPresent());
    assertEquals(EMAIL_TEST, userResponse.get().getEmail());
  }

}