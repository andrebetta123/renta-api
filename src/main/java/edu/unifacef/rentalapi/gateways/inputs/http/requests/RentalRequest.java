package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import edu.unifacef.rentalapi.domains.Kilometers;
import edu.unifacef.rentalapi.domains.TankStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RentalRequest implements Serializable {
	 
	private static final long serialVersionUID = -4484960512986846885L;
	
	@ApiModelProperty(position = 1)
	@NotNull(message = "{required.field}")
	private String id;
	
	@ApiModelProperty(position = 2)
	@NotNull(message = "{required.field}")
	private String carBoard;
	
	@ApiModelProperty(position = 3)
	private LocalDateTime deliveryDate;

	@ApiModelProperty(position = 4)
	private LocalDateTime leaseDate;
	
	@ApiModelProperty(position = 5)
	private String costumerId;
	
	@ApiModelProperty(position = 5)
	private Double leaseValue;
	
	@ApiModelProperty(position = 7)
	private Kilometers kilometers;
	
	@ApiModelProperty(position = 8)
	private TankStatus tankStatus;
	
}
