package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.unifacef.rentalapi.domains.Kilometers;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("Kilometers")
public class KilometersDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal initialKm;
	private BigDecimal returnKm;

	public KilometersDocument(final Kilometers kilometers) {
		this.initialKm = kilometers.getInitialKm();
		this.returnKm = kilometers.getReturnKm();
	}

//	public Kilometers toDomain() {
//		return Kilometers.builder().board(this.returnKm).board(this.initialKm).build();
//	}
}