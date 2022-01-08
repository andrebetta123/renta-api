package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unifacef.rentalapi.domains.Car;
import edu.unifacef.rentalapi.domains.TankStatus;
import edu.unifacef.rentalapi.domains.TypeCar;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("cars")
public class CarDocument {
	
	@Id
	private String id;	
	private String brand;
	private String model;
	private String color;
	private String year;	
	private TypeCar typeCar;
	private TankStatus tankStatus;
	private Boolean availability;
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime lastModifieldDate;
	
	
	public CarDocument(final Car car) {
		this.id = car.getBoard();		
		this.brand = car.getBrand();
		this.model = car.getModel();
		this.color = car.getColor();
		this.year = car.getYear();
		this.typeCar = car.getTypeCar();
		this.tankStatus = car.getTankStatus();
		this.availability = car.getAvailability();
		this.createdDate = car.getCreatedDate();
		this.lastModifieldDate = car.getLastModifieldDate();
		
		
	}
	
	public Car toDomain() {
		return Car.builder()			
			.board(this.id)
			.brand(this.brand)
			.model(this.model)
			.color(this.color)
			.year(this.year)
			.typeCar(this.typeCar)
			.tankStatus(this.tankStatus)
			.availability(this.availability)
			.createdDate(this.createdDate)
			.lastModifieldDate(this.lastModifieldDate)
			.build();		
		
	}
	

}	

/*
  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<AttributeDocument> attributes;

  public CarDocument(final Car car) {
    this.name = car.getName();
    this.description = car.getDescription();
    this.brand = car.getBrand();
    this.images = car.getImages();
    this.attributes = emptyIfNull(car.getAttributes())
        .stream().map(AttributeDocument::new).collect(toList());
  }

  public Car toDomain() {
    return Car.builder()
        .name(this.name)
        .description(this.description)
        .brand(this.brand)
        .images(this.images)
        .attributes(emptyIfNull(this.attributes).stream()
            .map(AttributeDocument::toDomain).collect(toList()))
        .build();
  }

}
*/