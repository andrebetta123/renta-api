package edu.unifacef.rentalapi.configurations.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"edu.unifacef.rentalapi.gateways.outputs.mongodb"})
public class MongoDbConfiguration {}
