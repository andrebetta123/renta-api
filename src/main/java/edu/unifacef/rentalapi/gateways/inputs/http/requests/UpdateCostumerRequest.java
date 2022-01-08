package edu.unifacef.rentalapi.gateways.inputs.http.requests;

import edu.unifacef.rentalapi.domains.Costumer;

public class UpdateCostumerRequest extends CostumerRequest {

    private static final long serialVersionUID = 8743997776881612716L;

    public Costumer toDomain(final String id) {
        return Costumer.builder()
                .id(id)
                .name(super.getName())
                .phone(super.getPhone())
                .driverLicense(super.getDriverLicense())
                .active(super.getActive())
                .address(super.getAddress())
                .build();
    }
}
