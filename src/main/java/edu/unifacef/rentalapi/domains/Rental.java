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
public class Rental {

  private String id;
  private String carBoard;
  private Car car;
  private Costumer costumer;
  private Price price;
  private Kilometers kilometers;
  private TankStatus tankStatus;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public Rental(final String carBoard) {
    this.carBoard = carBoard;
  }

}
