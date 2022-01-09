package edu.unifacef.rentalapi.gateways.inputs.http.responses;



import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.RentalRequest;


public class UpdateRentalCarRequest extends RentalRequest {
	
	private static final long serialVersionUID = -1414936822726798773L;
	
	public RentalCar toDomain(final String board) {
		return RentalCar.builder()
	    	.carBoard(super.getCarBoard())
//	    	.local
	    	.car(super.getCar())
	    	.costumer(super.getCostumer())
	    	.price(super.getPrice())
	    	.kilometers(super.getKilometers())
	    	.tankStatus(super.getTankStatus())
	        .build();				
	}

}
