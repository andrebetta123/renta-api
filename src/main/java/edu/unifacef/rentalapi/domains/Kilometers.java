package edu.unifacef.rentalapi.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "kilometers")
@Data
public class Kilometers implements Serializable {	
		
	private static final long serialVersionUID = 1L;	
		
	private BigDecimal kmInicial;
	private BigDecimal kmDevolucao;
		
}