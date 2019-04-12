package com.test.challenge.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.test.challenge.model.response.AvailableHotelsResponse;
import com.test.challenge.model.response.BestHotelsResponse;
import com.test.challenge.model.response.CrazyHotelsResponse;

public interface HotelsService {
	
	/**
	 * @param fromDate
	 * @param toDate
	 * @param city
	 * @param numberOfAdults
	 * @return List<AvailableHotelsResponse>
	 * @author Raghad Almanasreh
	 */
	public List<AvailableHotelsResponse> getAvailableHotels(Date fromDate, Date toDate, String city, int numberOfAdults) throws ParseException;
	
	/**
	 * @param from
	 * @param to
	 * @param city
	 * @param adultsCount
	 * @return List<CrazyHotelsResponse>
	 * @author Raghad Almansreh
	 */
	public List<CrazyHotelsResponse> getCrazyHotels(Date from, Date to, String city, int adultsCount) throws ParseException;
	
	/**
	 * @param fromDate
	 * @param toDate
	 * @param city
	 * @param numberOfAdults
	 * @return List<BestHotelsResponse>
	 * @author Raghad Almansreh
	 */
	public List<BestHotelsResponse> getBestHotels(Date fromDate, Date toDate, String city, int numberOfAdults) throws ParseException;
}
