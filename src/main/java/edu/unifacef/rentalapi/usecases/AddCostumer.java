package edu.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Costumer;
import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddCostumer {

  private final RentalCarDataGateway rentalCarDataGateway;

  public void execute(final String carBoard, final Costumer costumer) {
    log.info("Adding inventory. Car code: {}", carBoard);

    RentalCar rentalCar = rentalCarDataGateway
        .findByCode(carBoard).orElse(new RentalCar(carBoard));
    rentalCar.setCostumer(costumer);
    rentalCarDataGateway.save(rentalCar);
  }

//  public void execute(final Costumer costumer) {
//	    log.info("Adding inventory. Costumer: {}", costumer);
//
//	    RentalCar rental = new RentalCar();
////	    RentalCar rental = rentalCarDataGateway
////	        .findByCode(carBoard).orElse(new RentalCar(carBoard));
//	    rental.setCostumer(costumer);
//	    rentalCarDataGateway.save(rental);
//	  }

}
