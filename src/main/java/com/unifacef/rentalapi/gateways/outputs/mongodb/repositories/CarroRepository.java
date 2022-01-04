package com.unifacef.rentalapi.gateways.outputs.mongodb.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.unifacef.rentalapi.domain.Carro;

public interface CarroRepository extends MongoRepository<Carro, Long> {

}
