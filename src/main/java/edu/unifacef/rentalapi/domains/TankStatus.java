package edu.unifacef.rentalapi.domains;

public enum TankStatus {
	
	EMPTY("empty"),
	QUARTER("1/4"),
	HALF("1/2"),
	THREE_QUARTS("3/4"),
	FULL("full");	
	
	private String description;
	
	TankStatus(String description){
		this.description=description;
	}
	
	public String getDescription() {
		return description;
	}
	
	

}
