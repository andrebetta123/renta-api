package edu.unifacef.rentalapi.domains;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Costumer {

	private String id;
	private String name;
	private String phone;
	private String driverLicense;
	private Boolean active;
	private Address address;
	private LocalDateTime createdDate;
	private LocalDateTime lastModifiedDate;

}
