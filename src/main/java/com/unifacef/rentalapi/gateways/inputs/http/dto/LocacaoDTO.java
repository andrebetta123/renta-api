package com.unifacef.rentalapi.gateways.inputs.http.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.unifacef.rentalapi.domain.Carro;
import com.unifacef.rentalapi.domain.Cliente;
import com.unifacef.rentalapi.domain.Kilometros;
import com.unifacef.rentalapi.domain.Locacao;
import com.unifacef.rentalapi.domain.Preco;
import com.unifacef.rentalapi.domain.StatusTanque;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("locacoes")
public class LocacaoDTO implements Serializable {	
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	private Long id;
	@ApiModelProperty(dataType = "java.util.Date")
	private LocalDateTime dataEntrega;
	@ApiModelProperty(dataType = "java.util.Date")
	private LocalDateTime dataLocacao;
	private Carro carro;	
	private Cliente cliente;
	private Preco preco;
	private Kilometros kilometros;
	private StatusTanque statusTanque;
	private Boolean ativo;	
	@ApiModelProperty(dataType = "java.util.Date")
	@LastModifiedDate
	private LocalDateTime dataInclusao;
	@ApiModelProperty(dataType = "java.util.Date")
	@LastModifiedDate
	private LocalDateTime  dataModificacao;

	public LocacaoDTO(final Locacao locacao) {
		this.id = locacao.getId();
		this.dataEntrega = locacao.getDataEntrega();
		this.dataLocacao = locacao.getDataLocacao();
		this.carro = locacao.getCarro();
		this.cliente = locacao.getCliente();
		this.preco = locacao.getPreco();
		this.kilometros = locacao.getKilometros();
		this.statusTanque = locacao.getStatusTanque();
		this.ativo = locacao.getAtivo();
		this.dataInclusao = locacao.getDataInclusao();
		this.dataModificacao = locacao.getDataModificacao();
	}
	
	public Locacao toDomain() {
	    return Locacao.builder()
	    		.id(this.id)
	    		.dataEntrega(this.dataEntrega)
	    		.dataLocacao(this.dataLocacao)
	    		.carro(this.carro)
	    		.cliente(this.cliente)
	    		.preco(this.preco)
	    		.kilometros(this.kilometros)
	    		.statusTanque(this.statusTanque)
	    		.ativo(this.ativo)
	    		.dataInclusao(this.dataInclusao)
	    		.dataModificacao(this.dataModificacao)
	    	.build();
	  }

}
