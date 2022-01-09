package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import java.math.BigDecimal;

import edu.unifacef.rentalapi.domains.Kilometers;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KilometersDocument {

	private BigDecimal initialKm;
	private BigDecimal returnKm;

	public KilometersDocument(final Kilometers kilometers) {
		this.initialKm = kilometers.getInitialKm();
		this.returnKm = kilometers.getReturnKm();
	}

	public Kilometers toDomain() {
		return Kilometers.builder().initialKm(this.initialKm).returnKm(this.returnKm).build();
	}
}