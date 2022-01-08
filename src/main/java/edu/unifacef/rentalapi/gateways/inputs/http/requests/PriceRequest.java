package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import edu.unifacef.rentalapi.domains.Price;
import lombok.Data;

@Data
public class PriceRequest implements Serializable {

  private static final long serialVersionUID = 4733052956818304134L;

  @ApiModelProperty(position = 1)
  private Double from;

  @ApiModelProperty(position = 2)
  private Double to;

  public Price toDomain() {
    return Price.builder()
        .from(this.from)
        .to(this.to)
        .build();
  }
}
