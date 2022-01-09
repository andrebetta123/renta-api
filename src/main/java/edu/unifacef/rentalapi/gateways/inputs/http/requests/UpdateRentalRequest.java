package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import edu.unifacef.rentalapi.domains.Rental;

public class UpdateRentalRequest extends RentalRequest {

    private static final long serialVersionUID = 8743997776881612716L;

    public Rental toDomain(final String rentalId) {
        return Rental.builder()
                .id(rentalId)
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
