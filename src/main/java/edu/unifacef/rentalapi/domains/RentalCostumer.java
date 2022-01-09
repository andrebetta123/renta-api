package edu.unifacef.rentalapi.domains;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalCostumer {

  private String costumerId;
  private Costumer costumer;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public RentalCostumer(final String costumerId) {
    this.costumerId = costumerId;
  }

}
