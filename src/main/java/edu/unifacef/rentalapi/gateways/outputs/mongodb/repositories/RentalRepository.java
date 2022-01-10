package edu.unifacef.rentalapi.gateways.outputs.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.unifacef.rentalapi.gateways.outputs.mongodb.documents.RentalDocument;

public interface RentalRepository extends MongoRepository<RentalDocument, String> {
}
