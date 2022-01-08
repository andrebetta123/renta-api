package edu.unifacef.rentalapi.gateways.inputs.http.responses;



import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.RentalRequest;


public class UpdateRentalCarRequest extends RentalRequest {
	
	private static final long serialVersionUID = -1414936822726798773L;
	
	public Rental toDomain(final String board) {
		return Rental.builder()
			.carBoard(super.getCarBoard())
			.deliveryDate(super.getDeliveryDate())
			.leaseDate(super.getLeaseDate())
			.costumerId(super.getCostumerId())
			.leaseValue(super.getLeaseValue())
			.kilometers(super.getKilometers())
			.tankStatus(super.getTankStatus())
			.build();				
	}

}
