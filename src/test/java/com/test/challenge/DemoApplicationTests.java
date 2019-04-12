package com.test.challenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.challenge.model.response.AvailableHotelsResponse;
import com.test.challenge.model.response.BestHotelsResponse;
import com.test.challenge.model.response.CrazyHotelsResponse;
import com.test.challenge.service.HotelsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	HotelsService hotelsService;

	SimpleDateFormat formatter_ISO_LOCAL_DATE = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatter_ISO_INSTANT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	public HotelsService getHotelsService() {
		return hotelsService;
	}
	
	@Test
	public void getAllAvailableHoltelsTest() throws ParseException {
		List<AvailableHotelsResponse> availableHotelsResponse = getHotelsService().getAvailableHotels(
				formatter_ISO_LOCAL_DATE.parse("2019-05-02"), formatter_ISO_LOCAL_DATE.parse("2019-05-04"), "AMM", 1);
		Assert.assertEquals(1, availableHotelsResponse.size());
	}

	@Test
	public void getAllCrazyHotelsTest() throws ParseException {
		List<CrazyHotelsResponse> crazyHotelsResponse = getHotelsService().getCrazyHotels(
				formatter_ISO_INSTANT.parse("2019-04-22T18:46:19Z"),
				formatter_ISO_INSTANT.parse("2019-04-23T18:46:19Z"), "OED", 1);
		Assert.assertEquals(1, crazyHotelsResponse.size());
	}
	
	
	@Test
	public void getBestHotelsTest() throws ParseException {
		List<BestHotelsResponse> bestHotelsResponse = getHotelsService().getBestHotels(
				formatter_ISO_LOCAL_DATE.parse("2019-05-02"), formatter_ISO_LOCAL_DATE.parse("2019-05-04"), "OED", 1);

		Assert.assertEquals(0, bestHotelsResponse.size());
	}
	
	
	@Test
	public void getBestHotelsWithoutCityTest() throws ParseException {
		List<BestHotelsResponse> bestHotelsResponse = getHotelsService().getBestHotels(
				formatter_ISO_LOCAL_DATE.parse("2019-05-02"), formatter_ISO_LOCAL_DATE.parse("2019-05-04"), "", 1);

		Assert.assertEquals(0, bestHotelsResponse.size());
	}
}