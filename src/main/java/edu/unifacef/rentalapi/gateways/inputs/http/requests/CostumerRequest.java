package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import edu.unifacef.rentalapi.domains.Address;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CostumerRequest implements Serializable {

  private static final long serialVersionUID = 3475925051912891191L;

  @ApiModelProperty(position = 1)
  @NotNull(message = "{required.field}")
  private String name;

  @ApiModelProperty(position = 2)
  @NotNull(message = "{required.field}")
  private String phone;

  @ApiModelProperty(position = 3)
  private String driverLicense;

  @ApiModelProperty(position = 4)
  private Boolean active;

  @ApiModelProperty(position = 5)
//  @NotNull(message = "{required.field}")
  private Address address;

//  public Costumer toDomain() {
//    return Costumer.builder()
//    	.name(this.name)
//    	.phone(this.phone)
//    	.driverLicense(this.driverLicense)
//    	.active(this.active)
////    	.address(this.address)
//    	.build();
//  }
}
