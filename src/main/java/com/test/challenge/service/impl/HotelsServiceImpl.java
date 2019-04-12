package com.test.challenge.service.impl;

import static com.test.challenge.model.HotelsGenerator.createDummyHotels;
import static com.test.challenge.utils.Utils.getStarsRate;
import static com.test.challenge.utils.Utils.round;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test.challenge.enums.HotelProvider;
import com.test.challenge.model.Hotel;
import com.test.challenge.model.response.AvailableHotelsResponse;
import com.test.challenge.model.response.BestHotelsResponse;
import com.test.challenge.model.response.CrazyHotelsResponse;
import com.test.challenge.service.HotelsService;

@Service
public class HotelsServiceImpl implements HotelsService {
	
	@Override
	public List<AvailableHotelsResponse> getAvailableHotels(Date fromDate, Date toDate, String city, int numberOfAdults) throws ParseException{
		//To get the available hotels that meet the query (fromDate, toDate, city, numberOfAdults) 
 		List<Hotel> allAvailableHotels = getfilteredHotels(fromDate, toDate, numberOfAdults, city);
 		
		List<AvailableHotelsResponse> availableHotelsResponse = new ArrayList<AvailableHotelsResponse>();
		
		//To create the AvailableHotelsResponse List
		for (Hotel hotel : allAvailableHotels) {
			AvailableHotelsResponse availableHotelResponse = new AvailableHotelsResponse();
			availableHotelResponse.setAmenities(hotel.getAmenities());
			availableHotelResponse.setFare(hotel.getFare());
			availableHotelResponse.setHotelName(hotel.getHotelName());
			availableHotelResponse.setProvider(hotel.getProvider().getProvider());
			availableHotelsResponse.add(availableHotelResponse);
		}

		return availableHotelsResponse;
	}

	@Override
	public List<CrazyHotelsResponse> getCrazyHotels(Date from, Date to, String city, int adultsCount) throws ParseException{
		//To get the available hotels that meet the query (fromDate, toDate, city, numberOfAdults) 
		List<Hotel> allAvailableHotels = getfilteredHotels(from, to, adultsCount, city);
		
		List<CrazyHotelsResponse> crazyHotelsResponse = new ArrayList<CrazyHotelsResponse>();

		//To create the CrazyHotelsResponse List (Get only the available hotels with crazy hotel provider from all the available hotels list)
		for (Hotel hotel : allAvailableHotels.stream().filter(h -> h.getProvider().equals(HotelProvider.CRAZY_HOTELS)).collect(Collectors.toList())) {
			CrazyHotelsResponse crazyHotelResponse = new CrazyHotelsResponse();
			crazyHotelResponse.setHotelName(hotel.getHotelName());
			crazyHotelResponse.setRate(getStarsRate(hotel.getHotelRate()));
			crazyHotelResponse.setPrice(hotel.getFare());
			crazyHotelResponse.setDiscount(hotel.getDiscount());
			crazyHotelResponse.setAmenities(hotel.getAmenities());
			crazyHotelsResponse.add(crazyHotelResponse);
		}

		return crazyHotelsResponse;
	}

	@Override
	public List<BestHotelsResponse> getBestHotels(Date fromDate, Date toDate, String city, int numberOfAdults) throws ParseException{
		//To get the available hotels that meet the query (fromDate, toDate, city, numberOfAdults) 
		List<Hotel> allAvailableHotels = getfilteredHotels(fromDate, toDate, numberOfAdults, city);

		List<BestHotelsResponse> bestHotelsResponse = new ArrayList<BestHotelsResponse>();
		
		//To create the BestHotelsResponse List (Get only the available hotels with Best hotel provider from all the available hotels list)
		for (Hotel hotel : allAvailableHotels.stream().filter(h -> h.getProvider().equals(HotelProvider.BEST_HOTELS)).collect(Collectors.toList())) {
			BestHotelsResponse bestHotelResponse = new BestHotelsResponse();
			bestHotelResponse.setRoomAmenities(String.join(",", hotel.getAmenities()));
			bestHotelResponse.setHotelFare(round(hotel.getFare(), 2));
			bestHotelResponse.setHotelRate(hotel.getHotelRate());
			bestHotelResponse.setHotel(hotel.getHotelName());
			bestHotelsResponse.add(bestHotelResponse);
		}

		return bestHotelsResponse;
	}
	
	/**
	 * This method is to return All available hotels the meet the query (fromDate, toDate, numberOfAdults, city) sorted by hotel rate
	 */
	public List<Hotel> getfilteredHotels(Date fromDate, Date toDate, int numberOfAdults, String city) throws ParseException {

		// get all hotels
		List<Hotel> hotels = createDummyHotels();

		List<Hotel> result = new ArrayList<Hotel>();

		// filter all available hotels from all hotels that didn't meet the query
		for (Hotel hotelModel : hotels) {
			if (hotelModel.getCity().equalsIgnoreCase(city.toUpperCase()) && hotelModel.getNumberOfAdults() >= numberOfAdults)
				if (fromDate.after(hotelModel.getAvailableFromDate()) && toDate.before(hotelModel.getAvailableToDate()))
					result.add(hotelModel);
		}
		return sort(result);
	}
	
	private List<Hotel> sort(List<Hotel> hotels) {
		// sort the result list that contains all the right hotels by hotel rate
		Collections.sort(hotels, Comparator.comparingInt(Hotel::getHotelRate).reversed());

		return hotels;
	}
}
