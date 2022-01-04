package com.unifacef.rentalapi.gateways.outputs.mongodb;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.unifacef.rentalapi.domain.Locacao;
import com.unifacef.rentalapi.gateways.outputs.LocacaoDataGateway;
import com.unifacef.rentalapi.gateways.outputs.mongodb.documents.LocacaoDocument;
import com.unifacef.rentalapi.gateways.outputs.mongodb.repositories.LocacaoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LocacaoDataGatewayImpl implements LocacaoDataGateway {

	private final LocacaoRepository locacaoRepository;
		
	@Override
	public Locacao save(Locacao locacao) {
		if(Objects.isNull(locacao.getDataModificacao())) {
			locacao.setDataModificacao(LocalDateTime.now());
		}
		return locacaoRepository.save(new LocacaoDocument(locacao)).toDomain();
	}

	@Override
	public Optional<Locacao> findByCode(Long id) {
		return locacaoRepository.findById(id).map(LocacaoDocument::toDomain);
	}

	@Override
	public Page<Locacao> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		// return productRepository.findAll(pageable).map(ProductDocument::toDomain);
		return locacaoRepository.findAll(pageable).map(LocacaoDocument::toDomain);
	}

	
//	  @Override
//	  public Product save(final Product product) {
//	    if(Objects.isNull(product.getCreatedDate())) {
//	      product.setCreatedDate(LocalDateTime.now());
//	    }
//	    return productRepository.save(new ProductDocument(product)).toDomain();
//	  }
//
//	  @Override
//	  public Optional<Product> findByCode(final String code) {
//	    return productRepository.findById(code).map(ProductDocument::toDomain);
//	  }
//
//	  @Override
//	  public Page<Product> findByPage(final Pageable pageable) {
//	    return productRepository.findAll(pageable).map(ProductDocument::toDomain);
//	  }

}
