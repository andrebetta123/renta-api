package com.unifacef.rentalapi.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Locacao {	
	
	private Long id;
	private LocalDateTime dataEntrega;
	private LocalDateTime dataLocacao;
	private Carro carro;	
	private Cliente cliente;
	private Preco preco;
	private Kilometros kilometros;
	private StatusTanque statusTanque;
	private Boolean ativo;	
	private LocalDateTime dataInclusao;
	private LocalDateTime dataModificacao;


}
