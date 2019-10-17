package com.wallet.wallet.v1.controller;

import javax.validation.Valid;

import com.wallet.wallet.business.impl.UserBusinessImpl;
import com.wallet.wallet.common.DefaultResponse;
import com.wallet.wallet.dbo.model.User;
import com.wallet.wallet.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  @Autowired
  private UserBusinessImpl userBusinessImpl;

  @PostMapping
  public ResponseEntity<DefaultResponse<UserDto>> create(@Valid @RequestBody UserDto userDto,
      BindingResult bindingResult) {

    DefaultResponse<UserDto> response = new DefaultResponse<>();

    User user = userBusinessImpl.create(this.convertDtoToEntity(userDto));

    response.setData(this.convertEntityToDto(user));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  private User convertDtoToEntity(UserDto userDto) {
    return User.builder().name(userDto.getName()).email(userDto.getEmail()).password(userDto.getPassword()).build();
  }

  private UserDto convertEntityToDto(User user) {
    return UserDto.builder().name(user.getName()).email(user.getEmail()).password(user.getPassword()).build();
  }

}