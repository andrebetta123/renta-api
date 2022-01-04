package com.unifacef.rentalapi.gateways.inputs.http.requests;

import javax.validation.constraints.NotNull;

import com.unifacef.rentalapi.domain.Locacao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateLocacaoResquest extends LocacaoRequest {	
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{required.field}")
	private String code;

	
	public Locacao toDomain(final Long code) {
	    return Locacao.builder()
	    		.id(code)
	    		.dataEntrega(super.getDataEntrega())
	    		.dataLocacao(super.getDataLocacao())
	    		.carro(super.getCarro())
	    		.cliente(this.getCliente())
	    		.preco(this.getPreco())
	    		.kilometros(this.getKilometros())
	    		.statusTanque(this.getStatusTanque())
	    		.ativo(this.getAtivo())
	    		.dataInclusao(this.getDataInclusao())
	    		.dataModificacao(this.getDataModificacao())
	    	.build();
	  }
}
