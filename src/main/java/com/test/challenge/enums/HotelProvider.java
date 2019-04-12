package com.test.challenge.enums;

public enum HotelProvider {
	BEST_HOTELS("BestHotels"), CRAZY_HOTELS("CrazyHotels");
	
	private String provider;

	public String getProvider() {
		return provider;
	}

	HotelProvider(String provider) {
		this.provider = provider;
	}
}
