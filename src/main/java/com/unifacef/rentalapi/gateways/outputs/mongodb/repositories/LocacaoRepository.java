package com.unifacef.rentalapi.gateways.outputs.mongodb.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.unifacef.rentalapi.gateways.outputs.mongodb.documents.LocacaoDocument;

public interface LocacaoRepository extends MongoRepository<LocacaoDocument, Long> {

}
