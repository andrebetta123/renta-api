package edu.unifacef.rentalapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Price;
import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddPrice {

  private final RentalCarDataGateway rentalCarDataGateway;

  public void execute(final String carBoard, final Price price) {
    log.info("Adding price. Car code: {}", carBoard);

    Rental rental = rentalCarDataGateway
        .findByCode(carBoard).orElse(new Rental(carBoard));
    rental.setPrice(price);
    rentalCarDataGateway.save(rental);
  }
}
