package com.unifacef.rentalapi.gateways.outputs;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unifacef.rentalapi.domain.Locacao;

public interface LocacaoDataGateway {

  Locacao save(Locacao locacao);

  Optional<Locacao> findByCode(Long id);

  Page<Locacao> findByPage(Pageable pageable);	

}
