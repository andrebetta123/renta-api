package edu.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Costumer;
import edu.unifacef.rentalapi.domains.RentalCostumer;
import edu.unifacef.rentalapi.gateways.outputs.RentalCostumerDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddCostumer {

	private final RentalCostumerDataGateway rentalCostumerDataGateway;

	public void execute(final String id, final Costumer costumer) {
		log.info("Adding RentalCostumer. Costumer id: {}", id);

		RentalCostumer rentalCostumer = rentalCostumerDataGateway.findById(id).orElse(new RentalCostumer(id));
		rentalCostumer.setCostumer(costumer);
		rentalCostumerDataGateway.save(rentalCostumer);
	}
}
