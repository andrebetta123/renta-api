package edu.unifacef.rentalapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static edu.unifacef.rentalapi.exceptions.MessageKey.RENTAL_CAR_NOT_FOUND;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.exceptions.NotFoundException;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;
import edu.unifacef.rentalapi.utils.MessageUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByCarBoard {

	private final RentalCarDataGateway rentalCarDataGateway;
	private final MessageUtils messageUtils;

	public RentalCar execute(final String code) {
		log.info("Find rentalCar. Car code: {}", code);
		return rentalCarDataGateway.findByCode(code)
				.orElseThrow(() -> new NotFoundException(messageUtils.getMessage(RENTAL_CAR_NOT_FOUND, code)));
	}
}
