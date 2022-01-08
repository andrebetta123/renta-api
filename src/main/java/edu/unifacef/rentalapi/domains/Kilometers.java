package edu.unifacef.rentalapi.domains;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Kilometers  {	
		
	private BigDecimal initialKm;
	private BigDecimal returnKm;
		
}