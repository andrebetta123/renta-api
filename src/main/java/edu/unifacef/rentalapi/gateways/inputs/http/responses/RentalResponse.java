package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import static java.util.Optional.ofNullable;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.domains.TankStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RentalResponse implements Serializable {

	private static final long serialVersionUID = 2433564720627372962L;

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
	private KilometersResponse kilometers;

	@ApiModelProperty(position = 8)
	private TankStatus tankStatus;

	@ApiModelProperty(position = 9)
	private LocalDateTime createdDate;

	@ApiModelProperty(position = 10)
	private LocalDateTime lastModifiedDate;

	public RentalResponse(final Rental rental) {
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
