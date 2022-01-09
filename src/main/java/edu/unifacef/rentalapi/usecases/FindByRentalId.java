package edu.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import static edu.unifacef.rentalapi.exceptions.MessageKey.RENTAL_NOT_FOUND;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.exceptions.NotFoundException;
import edu.unifacef.rentalapi.gateways.outputs.RentalDataGateway;
import edu.unifacef.rentalapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByRentalId {

	private final RentalDataGateway rentalDataGateway;
	private final MessageUtils messageUtils;

	public Rental execute(final String id) {
		log.info("Find rental. Rental ID: {}", id);
		return rentalDataGateway.findById(id)
				.orElseThrow(() -> new NotFoundException(messageUtils.getMessage(RENTAL_NOT_FOUND, id)));
	}
}
