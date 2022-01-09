package edu.unifacef.rentalapi.gateways.outputs.mongodb;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.gateways.outputs.RentalCarDataGateway;
import edu.unifacef.rentalapi.gateways.outputs.mongodb.documents.RentalCarDocument;
import edu.unifacef.rentalapi.gateways.outputs.mongodb.repositories.RentalCarRepository;

@Component
@RequiredArgsConstructor
public class RentalCarDataGatewayMongoImpl implements RentalCarDataGateway {

  private final RentalCarRepository rentalCarRepository;

  @Override
  public RentalCar save(final RentalCar rentalCar) {
    if(Objects.isNull(rentalCar.getCreatedDate())) {
      rentalCar.setCreatedDate(LocalDateTime.now());
    }
    return rentalCarRepository.save(new RentalCarDocument(rentalCar)).toDomain();
  }

  @Override
  public Optional<RentalCar> findById(final String id) {
	System.out.println("Passou");
    return rentalCarRepository.findById(id).map(RentalCarDocument::toDomain);
  }

  @Override
  public Optional<RentalCar> findByCode(final String carBoard) {
	System.out.println("Passou");
    return rentalCarRepository.findById(carBoard).map(RentalCarDocument::toDomain);
  }

  @Override
  public Page<RentalCar> findByPage(final Pageable pageable) {
    return rentalCarRepository.findAll(pageable).map(RentalCarDocument::toDomain);
  }
}
