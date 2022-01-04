package com.unifacef.rentalapi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Document(value = "locacoes")
@Data
public class Preco implements Serializable {	
	
	private static final long serialVersionUID = 1L;	
	
	@Id	
	private TipoCarro tipoCarro;
	private BigDecimal preco;
	@JsonFormat(pattern="dd/mm/yyyy")
	@ApiModelProperty(dataType = "java.util.Date")
	private SimpleDateFormat dataInclusao;
	@JsonFormat(pattern="dd/mm/yyyy")
	@ApiModelProperty(dataType = "java.util.Date")
	private SimpleDateFormat dataModificacao;
	

}
