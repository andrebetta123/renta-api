package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import java.io.Serializable;

import edu.unifacef.rentalapi.domains.Price;
import lombok.Data;

@Data
public class PriceResponse implements Serializable {

  private static final long serialVersionUID = 3810524623457973402L;

  private Double from;
  private Double to;

  public PriceResponse(final Price price) {
    this.from = price.getFrom();
    this.to = price.getTo();
  }
}
