package edu.unifacef.rentalapi.domains;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

	private String board;
	private String brand;
	private String model;
	private String color;
	private String year;
	private TypeCar typeCar;
	private TankStatus tankStatus;
	private Boolean availability;
	private LocalDateTime createdDate;
	private LocalDateTime lastModifieldDate;

}
