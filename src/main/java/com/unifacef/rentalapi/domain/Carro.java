package com.unifacef.rentalapi.domain;

import java.io.Serializable;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(value = "carros")
public class Carro implements Serializable {	
	
	private static final long serialVersionUID = 1L;	
	
	@Id	
	private Long id;
	private String marca;
	private String modelo;
	private String cor;
	private Integer ano;
	private String placa;	
	private TipoCarro tipoCarro;	
	private StatusTanque statusTanque;
	private Boolean disponivel = true;
	private LocalDateTime dataInclusao;
	private LocalDateTime dataModificacao;
	
	private Cliente cliente;
	
	
	public Carro() {
		super();
	}
	

	public Carro(Long id, String marca, String modelo, String cor, Integer ano, String placa,
			TipoCarro tipoCarro, StatusTanque statusTanque,Boolean disponivel,LocalDateTime dataInclusao,LocalDateTime dataModificaccao, Cliente cliente) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.placa = placa;
		this.tipoCarro = tipoCarro;
		this.statusTanque = statusTanque;
		this.disponivel = disponivel;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificaccao;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
