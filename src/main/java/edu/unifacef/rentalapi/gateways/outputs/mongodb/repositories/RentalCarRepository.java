package edu.unifacef.rentalapi.gateways.outputs.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.unifacef.rentalapi.gateways.outputs.mongodb.documents.RentalCarDocument;

public interface RentalCarRepository extends MongoRepository<RentalCarDocument, String> {
}
