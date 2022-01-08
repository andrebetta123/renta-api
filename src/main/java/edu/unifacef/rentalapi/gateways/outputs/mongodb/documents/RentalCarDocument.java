package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unifacef.rentalapi.domains.Rental;

@Data
@NoArgsConstructor
@Document("rentalCars")
public class RentalCarDocument {

  @Id
  private String id;
  private String carBoard;
  private CarDocument car;
  private PriceDocument price;
  private CostumerDocument costumer;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public RentalCarDocument(final Rental rental) {
    this.id = rental.getId();
    this.carBoard = rental.getCarBoard();
    this.car = ofNullable(rental.getCar())
        .map(CarDocument::new).orElse(null);
    this.price = ofNullable(rental.getPrice())
        .map(PriceDocument::new).orElse(null);
    this.costumer = ofNullable(rental.getCostumer())
        .map(CostumerDocument::new).orElse(null);
    this.createdDate = rental.getCreatedDate();
    this.lastModifiedDate = rental.getLastModifiedDate();
  }

  public Rental toDomain() {
    return Rental.builder()
    	.id(this.id)
        .carBoard(this.carBoard)
        .car(ofNullable(this.car).map(CarDocument::toDomain).orElse(null))
        .price(ofNullable(this.price).map(PriceDocument::toDomain).orElse(null))
        .costumer(ofNullable(this.costumer).map(CostumerDocument::toDomain).orElse(null))
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}
