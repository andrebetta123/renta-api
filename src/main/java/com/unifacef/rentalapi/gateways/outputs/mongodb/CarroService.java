package com.unifacef.rentalapi.gateways.outputs.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacef.rentalapi.domain.Carro;
import com.unifacef.rentalapi.gateways.outputs.mongodb.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repository;
	
	
	public List<Carro> findAll(){
		return repository.findAll();
		
		
	}

}
