package edu.unifacef.rentalapi.gateways.outputs;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.unifacef.rentalapi.domains.RentalCar;

public interface RentalCarDataGateway {

  RentalCar save(RentalCar rentalCar);

  Optional<RentalCar> findByCode(String code);

  Optional<RentalCar> findById(String id);
  
  Page<RentalCar> findByPage(Pageable pageable);
}
