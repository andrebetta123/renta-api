package edu.unifacef.rentalapi.gateways.outputs.mongodb;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.outputs.RentalDataGateway;
import edu.unifacef.rentalapi.gateways.outputs.mongodb.documents.RentalDocument;
import edu.unifacef.rentalapi.gateways.outputs.mongodb.repositories.RentalRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RentalDataGatewayMongoImpl implements RentalDataGateway {

  private final RentalRepository rentalRepository;

  @Override
  public Rental save(final Rental rental) {
    if(Objects.isNull(rental.getCreatedDate())) {
      rental.setCreatedDate(LocalDateTime.now());
    }
    return rentalRepository.save(new RentalDocument(rental)).toDomain();
  }

  @Override
  public Optional<Rental> findById(final String rentalId) {
    return rentalRepository.findById(rentalId).map(RentalDocument::toDomain);
  }

  @Override
  public Page<Rental> findByPage(final Pageable pageable) {
    return rentalRepository.findAll(pageable).map(RentalDocument::toDomain);
  }
}
