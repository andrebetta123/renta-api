package com.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import com.unifacef.rentalapi.domain.Locacao;
import com.unifacef.rentalapi.gateways.outputs.LocacaoDataGateway;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateLocacao {

	private final LocacaoDataGateway locacaoDataGateway;
	
	public Locacao execute(final Locacao locacao) {
		Locacao saved = locacaoDataGateway.save(locacao);
		return saved;
	}
	  
}
