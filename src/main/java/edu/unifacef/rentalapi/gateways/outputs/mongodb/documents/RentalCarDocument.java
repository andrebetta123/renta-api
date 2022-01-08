package edu.unifacef.rentalapi.gateways.outputs.mongodb.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unifacef.rentalapi.domains.Kilometers;
import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.domains.TankStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("rentalCars")
public class RentalCarDocument {

	@Id
	private String id;
	private String carBoard;
	private LocalDateTime deliveryDate;
	private LocalDateTime leaseDate;
	private String costumerId;
	private Double leaseValue;
	private Kilometers kilometers;
	private TankStatus tankStatus;
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

//	@Id
//	private String id;
//	private String carBoard;
//	private CarDocument car;
//	private PriceDocument price;
//	private CostumerDocument costumer;
//	private LocalDateTime createdDate;
//	@LastModifiedDate
//	private LocalDateTime lastModifiedDate;

	public RentalCarDocument(final Rental rental) {
		this.id = rental.getId();
		this.carBoard = rental.getCarBoard();
		this.deliveryDate = rental.getDeliveryDate();
		this.leaseDate = rental.getLeaseDate();
		this.costumerId = rental.getCostumerId();
		this.leaseValue = rental.getLeaseValue();
		this.kilometers = rental.getKilometers();
		this.tankStatus = rental.getTankStatus();
		this.createdDate = rental.getCreatedDate();
		this.lastModifiedDate = rental.getLastModifiedDate();
	}

//	public Rental toDomain() {
//		return Rental.builder().id(this.id).carBoard(this.carBoard)
//				.car(ofNullable(this.car).map(CarDocument::toDomain).orElse(null))
//				.price(ofNullable(this.price).map(PriceDocument::toDomain).orElse(null))
//				.costumer(ofNullable(this.costumer).map(CostumerDocument::toDomain).orElse(null))
//				.createdDate(this.createdDate).lastModifiedDate(this.lastModifiedDate).build();
//	}
}
