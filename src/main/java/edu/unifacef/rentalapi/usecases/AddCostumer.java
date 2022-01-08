package edu.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Costumer;
import edu.unifacef.rentalapi.domains.Rental;
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

    Rental rental = rentalCarDataGateway
        .findByCode(carBoard).orElse(new Rental(carBoard));
    rental.setCostumer(costumer);
    rentalCarDataGateway.save(rental);
  }

//  public void execute(final Costumer costumer) {
//	    log.info("Adding inventory. Costumer: {}", costumer);
//
//	    Rental rental = new Rental();
////	    Rental rental = rentalCarDataGateway
////	        .findByCode(carBoard).orElse(new Rental(carBoard));
//	    rental.setCostumer(costumer);
//	    rentalCarDataGateway.save(rental);
//	  }

}
