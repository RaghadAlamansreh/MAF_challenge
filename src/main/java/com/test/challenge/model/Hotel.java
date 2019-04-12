package com.test.challenge.model;

import java.util.Date;

import com.test.challenge.enums.HotelProvider;

public class Hotel {
	
	private HotelProvider provider;
	private String hotelName;
	private double fare;
	private String[] amenities;
  	private int hotelRate;
 	private Integer discount;
 	private String city;
 	private Date availableFromDate;
 	private Date availableToDate;
 	private int numberOfAdults;
 	
	public Hotel(HotelProvider provider, String hotelName, double fare, String[] amenities, int hotelRate,
			Integer discount, String city, Date availableFromDate, Date availableToDate, int numberOfAdults) {
		this.provider = provider;
		this.hotelName = hotelName;
		this.fare = fare;
		this.amenities = amenities;
		this.hotelRate = hotelRate;
		this.discount = discount;
		this.city = city;
		this.availableFromDate = availableFromDate;
		this.availableToDate = availableToDate;
		this.numberOfAdults = numberOfAdults;
	}
	public HotelProvider getProvider() {
		return provider;
	}
	public void setProvider(HotelProvider provider) {
		this.provider = provider;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String[] getAmenities() {
		return amenities;
	}
	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}
	public int getHotelRate() {
		return hotelRate;
	}
	public void setHotelRate(int hotelRate) {
		this.hotelRate = hotelRate;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getAvailableFromDate() {
		return availableFromDate;
	}
	public void setAvailableFromDate(Date availableFromDate) {
		this.availableFromDate = availableFromDate;
	}
	public Date getAvailableToDate() {
		return availableToDate;
	}
	public void setAvailableToDate(Date availableToDate) {
		this.availableToDate = availableToDate;
	}
	public int getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
}
