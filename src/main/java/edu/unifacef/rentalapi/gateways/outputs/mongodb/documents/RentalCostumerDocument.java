package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unifacef.rentalapi.domains.RentalCostumer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("rentalCostumers")
public class RentalCostumerDocument {

  @Id
  private String costumerId;
  private CostumerDocument costumer;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public RentalCostumerDocument(final RentalCostumer rentalCostumer) {
    this.costumerId = rentalCostumer.getCostumerId();
    this.costumer = ofNullable(rentalCostumer.getCostumer())
        .map(CostumerDocument::new).orElse(null);
    this.createdDate = rentalCostumer.getCreatedDate();
    this.lastModifiedDate = rentalCostumer.getLastModifiedDate();
  }

  public RentalCostumer toDomain() {
    return RentalCostumer.builder()
    	.costumerId(this.costumer.getId())
        .costumer(ofNullable(this.costumer).map(CostumerDocument::toDomain).orElse(null))
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}
