package com.unifacef.rentalapi.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value="clientes")
public class Cliente {
	
	
	private Long id;
	private String nome;	
	private String telefone;
	private String cnh;
	private Boolean ativo;
	private Endereco endereco;
	private Carro carro;
}
