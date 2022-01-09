package edu.unifacef.rentalapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindRentalCars {

  private final RentalCarDataGateway rentalCarDataGateway;

  public Page<RentalCar> execute(final Pageable pageable) {
    log.info("Find rentalCars. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
    return rentalCarDataGateway.findByPage(pageable);
  }
}
