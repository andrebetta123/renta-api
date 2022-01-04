package com.unifacef.rentalapi.gateways.inputs.http;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacef.rentalapi.domain.Carro;
import com.unifacef.rentalapi.gateways.inputs.http.dto.CarroDTO;
import com.unifacef.rentalapi.gateways.outputs.mongodb.CarroService;

import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/aluguel-api/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public ResponseEntity<List <CarroDTO>> listaCarros ( ){
		List<Carro> list = carroService.findAll();
		List<CarroDTO> listDTO = list.stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());		
		return ResponseEntity.ok().body(listDTO);
		
		
		
	}

}
