package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import edu.unifacef.rentalapi.domains.Attribute;
import lombok.Data;

@Data
public class AttributeRequest implements Serializable {

  private static final long serialVersionUID = 3211518364328089218L;

  @ApiModelProperty(position = 1)
  private String key;

  @ApiModelProperty(position = 2)
  private String value;

  public Attribute toDomain() {
    return Attribute.builder()
        .key(this.key)
        .value(this.value)
        .build();
  }
}
