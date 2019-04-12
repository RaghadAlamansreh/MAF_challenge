package com.test.challenge.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.challenge.model.response.AvailableHotelsResponse;
import com.test.challenge.model.response.BestHotelsResponse;
import com.test.challenge.model.response.CrazyHotelsResponse;
import com.test.challenge.service.HotelsService;

@RestController
@Validated
public class HotelsController {
	
	@Autowired
	private HotelsService hotelsService;
	
	public HotelsService getHotelsService() {
		return hotelsService;
	}

	/**
	 * This Controller is to get all available hotels from all providers (Best_Hotel, Crazy_Hotel)
	 *	according to https://www.worldnetlogistics.com/iata-city-airport-codes/ all IATA codes is three uppercase letters 
	 *	according to  DateTimeFormatter.class ISO_LOCAL_DATE pattern is "yyyy-MM-dd"
	 */
	@RequestMapping(value = "/availableHotels", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<AvailableHotelsResponse>> getAvailableHotels(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
			@RequestParam @Size(min = 3, max = 3, message = "IATA codes must be 3 uppercase letters") String city,
			@RequestParam(defaultValue = "1") int numberOfAdults){
		
		try {
			return ResponseEntity.ok().body(getHotelsService().getAvailableHotels(fromDate, toDate, city, numberOfAdults));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	/**
	 * This Controller is to get the available hotels from Best_hotel provider 
	 * 	according to https://www.worldnetlogistics.com/iata-city-airport-codes/ all IATA codes is three uppercase letters 
	 *	according to DateTimeFormatter.class ISO_LOCAL_DATE pattern is "yyyy-MM-dd"
	 */
	@RequestMapping(value = "/bestHotels", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<BestHotelsResponse>> getBestHotels(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
			@RequestParam @Size(min = 3, max = 3, message = "IATA codes must be 3 uppercase letters") String city,
			@RequestParam(defaultValue = "1") int numberOfAdults){
		try {
			return ResponseEntity.ok().body(getHotelsService().getBestHotels(fromDate, toDate, city, numberOfAdults));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	/**
	 * This Controller is to get the available hotels from Crazy_Hotel provider 
	 * 	according to https://www.worldnetlogistics.com/iata-city-airport-codes/ all IATA codes is three uppercase letters 
	 *	according to DateTimeFormatter.class ISO_INSTANT pattern is "yyyy-MM-dd'T'HH:mm:ss'Z'"
	 */
	@RequestMapping(value = "/crazyHotels", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CrazyHotelsResponse>> getCrazyHotels(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") Date from,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") Date to,
			@RequestParam @Size(min = 3, max = 3, message = "IATA codes must be 3 uppercase letters") String city, 
			@RequestParam(defaultValue = "1") int adultsCount){
		try {
			return ResponseEntity.ok().body(getHotelsService().getCrazyHotels(from, to, city, adultsCount));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
}