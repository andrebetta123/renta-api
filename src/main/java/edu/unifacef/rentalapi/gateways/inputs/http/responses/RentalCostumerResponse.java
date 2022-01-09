package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import static java.util.Optional.ofNullable;

import java.io.Serializable;
import java.time.LocalDateTime;

import edu.unifacef.rentalapi.domains.RentalCostumer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RentalCostumerResponse implements Serializable {

  private static final long serialVersionUID = 2433564720627372962L;

//  @ApiModelProperty(position = 0)
//  private String id;

  @ApiModelProperty(position = 1)
  private String costumerId;

  @ApiModelProperty(position = 2)
  private CostumerResponse costumer;

  @ApiModelProperty(position = 5)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 6)
  private LocalDateTime lastModifiedDate;

  public RentalCostumerResponse(final RentalCostumer rentalCostumer) {
    this.costumerId = rentalCostumer.getCostumerId();
    this.costumer = ofNullable(rentalCostumer.getCostumer()).map(CostumerResponse::new).orElse(null);
    this.createdDate = rentalCostumer.getCreatedDate();
    this.lastModifiedDate = rentalCostumer.getLastModifiedDate();
  }
}
