package com.unifacef.rentalapi.gateways.inputs.http.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.unifacef.rentalapi.domain.Carro;
import com.unifacef.rentalapi.domain.StatusTanque;
import com.unifacef.rentalapi.domain.TipoCarro;



public class CarroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String marca;
	private String modelo;
	private String cor;
	private Integer ano;
	private String placa;
	private TipoCarro tipoCarro;
	private StatusTanque statusTanque;
	private Boolean disponivel;
	private LocalDateTime dataInclusao;
	private LocalDateTime dataModificacao;
	
	
	public CarroDTO() {
		super();
	}
	
	public CarroDTO(Carro obj) {
		super();
		this.id = obj.getId();
		this.marca = obj.getMarca();
		this.modelo = obj.getModelo();
		this.cor = obj.getCor();
		this.ano = obj.getAno();
		this.placa = obj.getPlaca();
		this.tipoCarro =obj.getTipoCarro();
		this.statusTanque = obj.getStatusTanque();
		this.disponivel=obj.getDisponivel();
		this.dataInclusao = obj.getDataInclusao();
		this.dataModificacao = obj.getDataModificacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	

	public TipoCarro getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(TipoCarro tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	public StatusTanque getStatusTanque() {
		return statusTanque;
	}

	public void setStatusTanque(StatusTanque statusTanque) {
		this.statusTanque = statusTanque;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDateTime dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	
		

}
