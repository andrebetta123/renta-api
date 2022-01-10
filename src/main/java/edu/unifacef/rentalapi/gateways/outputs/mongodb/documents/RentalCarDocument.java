package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unifacef.rentalapi.domains.RentalCar;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("rentalCars")
public class RentalCarDocument {

  @Id
  private String carBoard;
  private CarDocument car;
  private PriceDocument price;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public RentalCarDocument(final RentalCar rentalCar) {
    this.carBoard = rentalCar.getCarBoard();
    this.car = ofNullable(rentalCar.getCar())
        .map(CarDocument::new).orElse(null);
    this.price = ofNullable(rentalCar.getPrice())
        .map(PriceDocument::new).orElse(null);
    this.createdDate = rentalCar.getCreatedDate();
    this.lastModifiedDate = rentalCar.getLastModifiedDate();
  }

  public RentalCar toDomain() {
    return RentalCar.builder()
        .carBoard(this.carBoard)
        .car(ofNullable(this.car).map(CarDocument::toDomain).orElse(null))
        .price(ofNullable(this.price).map(PriceDocument::toDomain).orElse(null))
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}
