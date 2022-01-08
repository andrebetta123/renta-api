package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import java.io.Serializable;
import java.time.LocalDateTime;

import edu.unifacef.rentalapi.domains.Car;
import edu.unifacef.rentalapi.domains.TankStatus;
import edu.unifacef.rentalapi.domains.TypeCar;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarResponse implements Serializable {
	 
	private static final long serialVersionUID = 7720638133263136151L;
	
		
	@ApiModelProperty(position=0)
	private String board;
	
	@ApiModelProperty(position=1)
	private String brand;
	
	@ApiModelProperty(position=2)
	private String model;
	
	@ApiModelProperty(position=3)
	private String color;
	
	@ApiModelProperty(position=4)
	private String year;
	
	@ApiModelProperty(position=5)
	private TypeCar typeCar;
	
	@ApiModelProperty(position=6)
	private TankStatus tankStatus;
	
	@ApiModelProperty(position=7)
	private Boolean availability;
	
	@ApiModelProperty(position=8)
	private LocalDateTime createDate;
	
	@ApiModelProperty(position=9)
	private LocalDateTime lastModifiedDate;
	
	public CarResponse(final Car car) {		
		this.board = car.getBoard();
		this.brand = car.getBrand();
		this.model = car.getModel();
		this.color = car.getColor();
		this.year = car.getYear();
		this.typeCar = car.getTypeCar();
		this.tankStatus = car.getTankStatus();
		this.availability = car.getAvailability();
		this.createDate = car.getCreatedDate();
		this.lastModifiedDate = car.getLastModifieldDate();
		
		
	}

}
	/*
  private static final long serialVersionUID = 9189520552888285200L;

  @ApiModelProperty(position = 1)
  private String name;

  @ApiModelProperty(position = 2)
  private String description;

  @ApiModelProperty(position = 3)
  private String brand;

  @ApiModelProperty(position = 4)
  private List<String> images;

  @ApiModelProperty(position = 5)
  private List<AttributeResponse> attributes;

  public CarResponse(final Car car) {
    this.name = car.getName();
    this.description = car.getDescription();
    this.brand = car.getBrand();
    this.images = car.getImages();
    this.attributes = emptyIfNull(car.getAttributes())
        .stream().map(AttributeResponse::new).collect(toList());
  }

}
*/