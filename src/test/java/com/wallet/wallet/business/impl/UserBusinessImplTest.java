package com.wallet.wallet.business.impl;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.wallet.wallet.dbo.model.User;
import com.wallet.wallet.dbo.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserBusinessImplTest {

  @MockBean
  private UserRepository userRepository;

  @Autowired
  private UserBusinessImpl userBusinessImpl;

  @Before
  public void setUp() {
    BDDMockito.given(userRepository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
  }

  @Test
  public void testFindByEmail() {
    Optional<User> user = userBusinessImpl.findByEmail("email@teste.com");

    assertTrue(user.isPresent());
  }

}