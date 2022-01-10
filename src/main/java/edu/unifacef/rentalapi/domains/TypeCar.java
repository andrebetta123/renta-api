package edu.unifacef.rentalapi.domains;

public enum TypeCar {

	COMPACT("compact"), SEDAN("sedan"), SUBCOMPACT("subCompact"), LUX("lux");

	private String description;

	TypeCar(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
