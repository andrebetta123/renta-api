package edu.unifacef.rentalapi.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Kilometers implements Serializable {	
		
	private static final long serialVersionUID = 1L;	
		
	private BigDecimal initialKm;
	private BigDecimal returnKm;
		
}