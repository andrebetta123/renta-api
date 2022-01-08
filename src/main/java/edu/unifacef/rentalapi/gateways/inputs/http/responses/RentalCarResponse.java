package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import static java.util.Optional.ofNullable;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

import edu.unifacef.rentalapi.domains.Rental;
import lombok.Data;

@Data
public class RentalCarResponse implements Serializable {

  private static final long serialVersionUID = 2433564720627372962L;

  @ApiModelProperty(position = 0)
  private String id;

  @ApiModelProperty(position = 1)
  private String carBoard;

  @ApiModelProperty(position = 2)
  private CarResponse car;

  @ApiModelProperty(position = 3)
  private PriceResponse price;

  @ApiModelProperty(position = 4)
  private CostumerResponse inventory;

  @ApiModelProperty(position = 5)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 6)
  private LocalDateTime lastModifiedDate;

  public RentalCarResponse(final Rental rental) {
	this.id = rental.getId();
    this.carBoard = rental.getCarBoard();
    this.car = ofNullable(rental.getCar()).map(CarResponse::new).orElse(null);
    this.price = ofNullable(rental.getPrice()).map(PriceResponse::new).orElse(null);
    this.inventory = ofNullable(rental.getCostumer()).map(CostumerResponse::new).orElse(null);
    this.createdDate = rental.getCreatedDate();
    this.lastModifiedDate = rental.getLastModifiedDate();
  }
}
