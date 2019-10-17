package com.wallet.wallet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

  private Long id;
  @Length(min = 3, max = 50, message = "Nome deve conter entre 3 e 50 caracteres")
  private String name;
  @Email(message = "E-mail inválido")
  private String email;
  @NotNull
  @Length(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
  private String password;

}