package edu.unifacef.rentalapi.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.RentalCostumer;
import edu.unifacef.rentalapi.gateways.outputs.RentalCostumerDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindRentalCostumers {

  private final RentalCostumerDataGateway rentalCostumerDataGateway;

  public Page<RentalCostumer> execute(final Pageable pageable) {
    log.info("Find rental costumers. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
    return rentalCostumerDataGateway.findByPage(pageable);
  }
}
