package edu.unifacef.rentalapi.gateways.outputs.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.unifacef.rentalapi.gateways.outputs.mongodb.documents.RentalCostumerDocument;

public interface RentalCostumerRepository extends MongoRepository<RentalCostumerDocument, String> {
}
