package com.wallet.wallet.v1.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.wallet.business.impl.UserBusinessImpl;
import com.wallet.wallet.dbo.model.User;
import com.wallet.wallet.dto.UserDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

  private static final String NAME_TEST = "Fernando";
  private static final String EMAIL_TEST = "fernando.soares@luizalabs.com";
  private static final String PASSWORD_TEST = "123456";
  private static final String URL = "/v1/users";

  @MockBean
  UserBusinessImpl userBusinessImpl;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void testSave() throws Exception {

    BDDMockito.given(userBusinessImpl.create(Mockito.any(User.class))).willReturn(getMockUser());

    mockMvc.perform(MockMvcRequestBuilders.post(URL).content(this.getJsonPayload())
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

  }

  private User getMockUser() {
    return User.builder().name(NAME_TEST).email(EMAIL_TEST).password(PASSWORD_TEST).build();
  }

  private String getJsonPayload() throws JsonProcessingException {
    UserDto userDto = UserDto.builder().name(NAME_TEST).email(EMAIL_TEST).password(PASSWORD_TEST).build();

    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(userDto);
  }
}