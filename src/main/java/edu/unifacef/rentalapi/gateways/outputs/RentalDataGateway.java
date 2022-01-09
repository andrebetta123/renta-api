package edu.unifacef.rentalapi.gateways.outputs;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.unifacef.rentalapi.domains.Rental;

public interface RentalDataGateway {

  Rental save(Rental rental);

  Optional<Rental> findById(String id);
  
  Page<Rental> findByPage(Pageable pageable);
}
