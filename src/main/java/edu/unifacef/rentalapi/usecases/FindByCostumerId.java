package edu.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;
import static edu.unifacef.rentalapi.exceptions.MessageKey.RENTAL_COSTUMER_NOT_FOUND;

import edu.unifacef.rentalapi.domains.RentalCostumer;
import edu.unifacef.rentalapi.exceptions.NotFoundException;
import edu.unifacef.rentalapi.gateways.outputs.RentalCostumerDataGateway;
import edu.unifacef.rentalapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByCostumerId {

	private final RentalCostumerDataGateway rentalCostumerDataGateway;
	private final MessageUtils messageUtils;

	public RentalCostumer execute(final String id) {
		log.info("Find rentalCostumer. Costumer ID: {}", id);
		return rentalCostumerDataGateway.findById(id)
				.orElseThrow(() -> new NotFoundException(messageUtils.getMessage(RENTAL_COSTUMER_NOT_FOUND, id)));
	}
}
