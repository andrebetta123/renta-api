package com.unifacef.rentalapi.domain;

public enum StatusTanque {
	
	VAZIO("vazio"),
	UM_QUARTO("1/4"),
	MEIO("1/2"),
	TRES_QUARTOS("3/4"),
	CHEIO("cheio");	
	
	private String descricao;
	
	StatusTanque(String descricao){
		this.descricao=descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	

}
