package com.wallet.wallet.common;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DefaultResponse<T> {

  private T data;
  private List<String> errors;

}