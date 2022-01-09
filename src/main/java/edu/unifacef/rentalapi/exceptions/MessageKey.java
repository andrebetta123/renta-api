package edu.unifacef.rentalapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  RENTAL_CAR_NOT_FOUND("rental.car.not.found"),
  RENTAL_COSTUMER_NOT_FOUND("rental.costumer.not.found"),
  RENTAL_NOT_FOUND("rental.not.found"),
  RENTAL_ALREADY_EXISTS("rental.already.exists");

  private String key;

}
