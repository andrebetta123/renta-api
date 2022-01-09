package edu.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddRental {

  private final RentalCarDataGateway rentalCarDataGateway;

  public void execute(final String id, final RentalCar rentalCar) {
    log.info("Adding rental. Id: {}", id);

    RentalCar rentalNew = rentalCarDataGateway
        .findById(id).orElse(new RentalCar(id));
    rentalCarDataGateway.save(rentalNew);
  }
}
