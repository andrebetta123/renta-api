package edu.unifacef.rentalapi.usecases;

import static edu.unifacef.rentalapi.exceptions.MessageKey.RENTAL_NOT_FOUND;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.exceptions.NotFoundException;
import edu.unifacef.rentalapi.gateways.outputs.RentalDataGateway;
import edu.unifacef.rentalapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateRental {

	private final RentalDataGateway rentalDataGateway;
	private final MessageUtils messageUtils;

	public Rental execute(final String id, final Rental rental) {
		log.info("Update rental. Rental id: {}", rental.getId());
		Rental oldRental = rentalDataGateway.findById(rental.getId())
				.orElseThrow(() -> new NotFoundException(messageUtils.getMessage(RENTAL_NOT_FOUND, rental.getId())));
		rental.setCreatedDate(oldRental.getCreatedDate());

		Rental newRental = rentalDataGateway.save(rental);
		return newRental;
	}

}
