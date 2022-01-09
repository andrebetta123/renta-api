package edu.unifacef.rentalapi.gateways.inputs.http.responses;

import javax.validation.constraints.NotNull;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.RentalRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateRentalRequest extends RentalRequest {
	
	private static final long serialVersionUID = -6349644718099330841L;
	
	@NotNull(message = "{required.field}")
	private String id;
	
	
	public Rental toDomain() {
    return Rental.builder()
    	.id(this.id)
    	.carBoard(super.getCarBoard())
    	.deliveryDate(super.getDeliveryDate())
    	.leaseDate(super.getLeaseDate())
    	.costumerId(super.getCostumerId())
    	.leaseValue(super.getLeaseValue())
    	.kilometers(super.getKilometers())
    	.tankStatus(super.getTankStatus())
    	.car(super.getCar())
    	.price(super.getPrice())
    	.costumer(super.getCostumer())
        .build();
  }

	}


