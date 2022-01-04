package com.unifacef.rentalapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  LOCACAO_NOT_FOUND("locacao.not.found"),
  LOCACAO_ALREADY_EXISTS("locacao.already.exists");

  private String key;

}
