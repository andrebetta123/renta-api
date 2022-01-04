package com.unifacef.rentalapi.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(value = "kilometros")
@Data
public class Kilometros implements Serializable {	
	
	private static final long serialVersionUID = 1L;	
	
	private BigDecimal kmInicial;
	private BigDecimal kmDevolucao;
	
}
