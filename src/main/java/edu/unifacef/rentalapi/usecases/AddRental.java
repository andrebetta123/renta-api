package edu.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddRental {

  private final RentalCarDataGateway rentalCarDataGateway;

  public void execute(final String id, final Rental rental) {
    log.info("Adding rental. Id: {}", id);

    Rental rentalNew = rentalCarDataGateway
        .findById(id).orElse(new Rental(id));
    rentalCarDataGateway.save(rentalNew);
  }
}
