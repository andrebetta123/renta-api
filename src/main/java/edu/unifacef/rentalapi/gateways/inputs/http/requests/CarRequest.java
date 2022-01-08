package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import edu.unifacef.rentalapi.domains.Car;
import edu.unifacef.rentalapi.domains.TankStatus;
import edu.unifacef.rentalapi.domains.TypeCar;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarRequest implements Serializable {
	 
	private static final long serialVersionUID = 8118179978951453306L;

	@ApiModelProperty(position = 1)
	@NotNull(message = "{required.field}")
	private String brand;
	
	@ApiModelProperty(position = 2)
	@NotNull(message = "{required.field}")
	private String model;
	
	@ApiModelProperty(position = 3)
	@NotNull(message = "{required.field}")
	private String color;
	
	@ApiModelProperty(position = 4)
	@NotNull(message = "{required.field}")
	private String year;
	
	@ApiModelProperty(position = 5)
	@NotNull(message = "{required.field}")
	private TypeCar typeCar;
	
	@ApiModelProperty(position = 6)
	@NotNull(message = "{required.field}")
	private TankStatus tankStatus;
	
	@ApiModelProperty(position = 7)
	@NotNull(message = "{required.field}")
	private Boolean availability;

	  public Car toDomain() {
		    return Car.builder()
		    	.brand(this.brand)
		    	.model(this.model)
		    	.color(this.color)
		    	.year(this.year)
		    	.typeCar(this.typeCar)
		    	.tankStatus(this.tankStatus)
		    	.availability(this.availability)
		        .build();
		  }

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
