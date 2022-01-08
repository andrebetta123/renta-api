package edu.unifacef.rentalapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Car;
import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddCar {

  private final RentalCarDataGateway rentalCarDataGateway;

  public void execute(final String carBoard, final Car car) {
    log.info("Adding rental. Car board: {}", carBoard);

    Rental rental = rentalCarDataGateway
        .findByCode(carBoard).orElse(new Rental(carBoard));
    rental.setCar(car);
    rentalCarDataGateway.save(rental);
  }
}
