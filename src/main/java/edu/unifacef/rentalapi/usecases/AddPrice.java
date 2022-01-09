package edu.unifacef.rentalapi.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Price;
import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddPrice {

	private final RentalCarDataGateway rentalCarDataGateway;

	public void execute(final String carBoard, final Price price) {
		log.info("Adding price. Car code: {}", carBoard);

		RentalCar rentalCar = rentalCarDataGateway.findByCode(carBoard).orElse(new RentalCar(carBoard));
		rentalCar.setPrice(price);
		rentalCarDataGateway.save(rentalCar);
	}
}
