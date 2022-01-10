package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.domains.TankStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("rentals")
public class RentalDocument {

  @Id
  private String id;
  private String carBoard;
  private LocalDateTime deliveryDate;
  private LocalDateTime leaseDate;
  private String costumerId;
  private Double leaseValue;
  private KilometersDocument kilometers;
  private TankStatus tankStatus;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;  

  public RentalDocument(final Rental rental) {
    this.id = rental.getId();
    this.carBoard = rental.getCarBoard();
    this.carBoard = rental.getCarBoard();
    this.deliveryDate = rental.getDeliveryDate();
    this.leaseDate = rental.getLeaseDate();
    this.costumerId = rental.getCostumerId();
    this.leaseValue = rental.getLeaseValue();
    this.kilometers = ofNullable(rental.getKilometers())
            .map(KilometersDocument::new).orElse(null);;
    this.tankStatus = rental.getTankStatus();
    this.createdDate = rental.getCreatedDate();
    this.lastModifiedDate = rental.getLastModifiedDate();
  }

  public Rental toDomain() {
    return Rental.builder()
    		.id(this.id)
    		.carBoard(this.carBoard)
    		.deliveryDate(this.deliveryDate)
    		.leaseDate(this.leaseDate)
    		.costumerId(this.costumerId)
    		.leaseValue(this.leaseValue)
    		.kilometers(ofNullable(kilometers).map(KilometersDocument::toDomain).orElse(null))
    		.tankStatus(this.tankStatus)
    		.createdDate(this.createdDate)
    		.lastModifiedDate(this.lastModifiedDate)    		
            .build();
      }

}
