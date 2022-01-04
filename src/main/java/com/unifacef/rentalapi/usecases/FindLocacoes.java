package com.unifacef.rentalapi.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.unifacef.rentalapi.domain.Locacao;
import com.unifacef.rentalapi.gateways.outputs.LocacaoDataGateway;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindLocacoes {
	  
	private final LocacaoDataGateway locacaoDataGateway;

	public Page<Locacao> execute(final Pageable pageable) {
	   //log.info("Find products. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
	   return locacaoDataGateway.findByPage(pageable);
	}

}
