package com.test.challenge.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.test.challenge.enums.HotelProvider;

public class HotelsGenerator {

	/**
	 * This method is to create dummy hotels object
	 */
	public static List<Hotel> createDummyHotels() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<Hotel> hotels = new ArrayList<Hotel>();

		Hotel hotel = new Hotel(HotelProvider.BEST_HOTELS, "Rayshan", 10.36985,
				new String[] { "Kitchen facilities", "Television", "Computer and Internet access" }, 1, 20, "AMM",
				dateFormat.parse("2019-04-15"), dateFormat.parse("2019-04-20"), 1);
		hotels.add(hotel);

		hotel = new Hotel(HotelProvider.BEST_HOTELS, "Albasem Hotel", 100,
				new String[] { "Personal items", "Towels", "Computer and Internet access" }, 2, 20, "AMM",
				dateFormat.parse("2019-05-01"), dateFormat.parse("2019-05-20"), 5);
		hotels.add(hotel);

		hotel = new Hotel(HotelProvider.BEST_HOTELS, "The House Boutique Suites", 100,
				new String[] { "Personal items", "Towels", "Hair dryer" }, 3, 20, "OED", dateFormat.parse("2019-04-15"),
				dateFormat.parse("2019-04-22"), 1);
		hotels.add(hotel);

		hotel = new Hotel(HotelProvider.CRAZY_HOTELS, "Sandy Palace", 100,
				new String[] { "Personal items", "Towels", "Recreation" }, 2, 20, "OED", dateFormat.parse("2019-04-20"),
				dateFormat.parse("2019-04-25"), 5);
		hotels.add(hotel);

		hotel = new Hotel(HotelProvider.CRAZY_HOTELS, "Sydney", 100,
				new String[] { "Personal items", "Swimming pools", "Hair dryer" }, 5, null, "AUH",
				dateFormat.parse("2019-05-01"), dateFormat.parse("2019-05-20"), 1);
		hotels.add(hotel);

		hotel = new Hotel(HotelProvider.CRAZY_HOTELS, "Nomads", 100,
				new String[] { "Exercise", "Towels", "Hair dryer" }, 3, 20, "AUH", dateFormat.parse("2019-06-01"),
				dateFormat.parse("2019-06-05"), 5);
		hotels.add(hotel);

		return hotels;
	}
}
