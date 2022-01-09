package edu.unifacef.rentalapi.gateways.outputs.mongodb;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.RentalCostumer;
import edu.unifacef.rentalapi.gateways.outputs.RentalCostumerDataGateway;
import edu.unifacef.rentalapi.gateways.outputs.mongodb.documents.RentalCostumerDocument;
import edu.unifacef.rentalapi.gateways.outputs.mongodb.repositories.RentalCostumerRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RentalCostumerDataGatewayMongoImpl implements RentalCostumerDataGateway {

	private final RentalCostumerRepository rentalCostumerRepository;

	@Override
	public RentalCostumer save(final RentalCostumer rentalCostumer) {
		if (Objects.isNull(rentalCostumer.getCreatedDate())) {
			rentalCostumer.setCreatedDate(LocalDateTime.now());
		}
		return rentalCostumerRepository.save(new RentalCostumerDocument(rentalCostumer)).toDomain();
	}

	@Override
	public Optional<RentalCostumer> findById(final String id) {
		System.out.println("PassouCostumer");
		return rentalCostumerRepository.findById(id).map(RentalCostumerDocument::toDomain);
	}

	@Override
	public Page<RentalCostumer> findByPage(final Pageable pageable) {
		return rentalCostumerRepository.findAll(pageable).map(RentalCostumerDocument::toDomain);
	}
}
