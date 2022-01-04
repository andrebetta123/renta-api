package com.unifacef.rentalapi.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.unifacef.rentalapi.gateways.outputs.mongodb.repositories"})
public class MongoConfiguration {

}
