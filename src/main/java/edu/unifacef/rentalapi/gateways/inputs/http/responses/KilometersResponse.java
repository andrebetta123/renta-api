package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import java.io.Serializable;
import java.math.BigDecimal;

import edu.unifacef.rentalapi.domains.Kilometers;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KilometersResponse implements Serializable {	
		
	private static final long serialVersionUID = 1L;	

    @ApiModelProperty(position = 1)
	private BigDecimal initialKm;

    @ApiModelProperty(position = 2)
	private BigDecimal returnKm;

    public KilometersResponse(final Kilometers kilometers) {		
		this.initialKm = kilometers.getInitialKm();
		this.returnKm = kilometers.getReturnKm();
    }
    
		
}