package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import static java.util.Optional.ofNullable;

import java.io.Serializable;
import java.time.LocalDateTime;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.domains.TankStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RentalCarResponse implements Serializable {

	private static final long serialVersionUID = 2433564720627372962L;

	@ApiModelProperty(position = 0)
	private String id;

	@ApiModelProperty(position = 1)
	private String carBoard;

	@ApiModelProperty(position = 2)
//	@NotNull(message = "{required.field}")
	private LocalDateTime deliveryDate;

	@ApiModelProperty(position = 3)
	private LocalDateTime leaseDate;

	@ApiModelProperty(position = 4)
	private String costumerId;

	@ApiModelProperty(position = 5)
	private Double leaseValue;

	@ApiModelProperty(position = 6)
	private KilometersResponse kilometers;

	@ApiModelProperty(position = 7)
	private TankStatus tankStatus;

	@ApiModelProperty(position = 8)
	private LocalDateTime createdDate;

	@ApiModelProperty(position = 9)
	private LocalDateTime lastModifiedDate;

	public RentalCarResponse(final Rental rental) {
		this.id = rental.getId();
		
		this.carBoard = rental.getCarBoard();
		this.deliveryDate = rental.getDeliveryDate();
		this.leaseDate = rental.getLeaseDate();
		this.costumerId = rental.getCostumerId();
		this.leaseValue = rental.getLeaseValue();
		this.kilometers = ofNullable(rental.getKilometers()).map(KilometersResponse::new).orElse(null);
		this.tankStatus = rental.getTankStatus();
		this.createdDate = rental.getCreatedDate();
		this.lastModifiedDate = rental.getLastModifiedDate();
		
	}
}
