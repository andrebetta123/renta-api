package com.unifacef.rentalapi.gateways.outputs.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unifacef.rentalapi.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Long> {

}
