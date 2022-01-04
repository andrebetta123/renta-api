package com.unifacef.rentalapi.usecases;

import org.springframework.stereotype.Component;

import com.unifacef.rentalapi.domain.Locacao;
import com.unifacef.rentalapi.exceptions.MessageKey;
import com.unifacef.rentalapi.exceptions.NotFoundException;
import com.unifacef.rentalapi.gateways.outputs.LocacaoDataGateway;
import com.unifacef.rentalapi.utils.MessageUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateLocacao {

	private final LocacaoDataGateway locacaoDataGateway;
	private final MessageUtils messageUtils;

	public Locacao execute(final Locacao locacao) {
		Locacao oldLocacao = locacaoDataGateway.findByCode(locacao.getId()).orElseThrow(
				() -> new NotFoundException(messageUtils.getMessage(MessageKey.LOCACAO_NOT_FOUND, locacao.getId())));
		locacao.setDataInclusao(oldLocacao.getDataInclusao());

		Locacao saved = locacaoDataGateway.save(locacao);

		return saved;
	}

}
