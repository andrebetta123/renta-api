package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import edu.unifacef.rentalapi.domains.Car;
import edu.unifacef.rentalapi.domains.Costumer;
import edu.unifacef.rentalapi.domains.Kilometers;
import edu.unifacef.rentalapi.domains.Price;
import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.domains.TankStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class RentalRequest implements Serializable {
	 
	private static final long serialVersionUID = -4484960512986846885L;
	
//	@ApiModelProperty(position = 1)
//	@NotNull(message = "{required.field}")
//	private String id;
//	
	@ApiModelProperty(position = 2)
	@NotNull(message = "{required.field}")
	private String carBoard;
	
	@ApiModelProperty(position = 3)
//	@NotNull(message = "{required.field}")
	private Car car;
	
	@ApiModelProperty(position = 4)
//	@NotNull(message = "{required.field}")
	private Costumer costumer;
	
	@ApiModelProperty(position = 5)
//	@NotNull(message = "{required.field}")
	private Price price;
	
	@ApiModelProperty(position = 6)
//	@NotNull(message = "{required.field}")
	private Kilometers kilometers;
	
	@ApiModelProperty(position = 7)
//	@NotNull(message = "{required.field}")
	private TankStatus tankStatus;
	
	
//	  public RentalCar toDomain() {
//		    return RentalCar.builder()
////		    	.id(this.id)
//		    	.carBoard(this.carBoard)
//		    	.car(this.car)
//		    	.costumer(this.costumer)
//		    	.price(this.price)
//		    	.kilometers(this.kilometers)
//		    	.tankStatus(this.tankStatus)
//		        .build();
//		  }

}
/*  private static final long serialVersionUID = -4089111392479104913L;

  @ApiModelProperty(position = 1)
  private String name;

  @ApiModelProperty(position = 2)
  private String description;

  @ApiModelProperty(position = 3)
  private String brand;

  @ApiModelProperty(position = 4)
  private List<String> images;

  @ApiModelProperty(position = 5)
  private List<AttributeRequest> attributes;

  public Car toDomain() {
    return Car.builder()
        .name(this.name)
        .description(this.description)
        .brand(this.brand)
        .images(this.images)
        .attributes(emptyIfNull(this.attributes).stream()
            .map(AttributeRequest::toDomain).collect(toList()))
        .build();
  }

} */
