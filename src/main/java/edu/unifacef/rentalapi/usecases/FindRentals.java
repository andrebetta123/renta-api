package edu.unifacef.rentalapi.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.outputs.RentalDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindRentals {

	private final RentalDataGateway rentalDataGateway;

	public Page<Rental> execute(final Pageable pageable) {
		log.info("Find rentals. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
		return rentalDataGateway.findByPage(pageable);
	}
}
