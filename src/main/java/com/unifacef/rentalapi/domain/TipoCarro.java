package com.unifacef.rentalapi.domain;

public enum TipoCarro {
	
	COMPACTO("compacto"),
	SEDAN("sedan"),
	SUBCOMPACTO("subCompacto"),
	LUXO("luxo");
	
	private String descricao;
	
	TipoCarro(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
