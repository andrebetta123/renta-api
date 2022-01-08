package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import edu.unifacef.rentalapi.domains.Attribute;
import lombok.Data;

@Data
public class AttributeResponse implements Serializable {

  private static final long serialVersionUID = 7808546186559340341L;

  @ApiModelProperty(position = 1)
  private String key;

  @ApiModelProperty(position = 2)
  private String value;

  public AttributeResponse(final Attribute attribute) {
    this.key = attribute.getKey();
    this.value = attribute.getValue();
  }

}
