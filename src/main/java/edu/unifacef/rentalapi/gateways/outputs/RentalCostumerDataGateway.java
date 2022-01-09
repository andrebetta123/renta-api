package edu.unifacef.rentalapi.gateways.outputs;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.unifacef.rentalapi.domains.RentalCostumer;

public interface RentalCostumerDataGateway {

	RentalCostumer save(RentalCostumer rentalCostumer);

	Optional<RentalCostumer> findById(String id);

	Page<RentalCostumer> findByPage(Pageable pageable);
}
