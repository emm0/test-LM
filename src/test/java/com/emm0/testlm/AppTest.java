package com.emm0.testlm;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.emm0.testlm.model.SearcherResponse;
import com.emm0.testlm.searcher.api.FlightPriceConfig;
import com.emm0.testlm.searcher.api.FlightSearcher;
import com.emm0.testlm.searcher.impl.FlightSearcherImpl;

/**
 * Unit test for the App.
 */
public class AppTest {
	/**
	 * Main module to test
	 */
	FlightSearcher flightSearcher = new FlightSearcherImpl();

	DecimalFormat df;

	@Before
	public void beforeTest() {

		DecimalFormatSymbols symb = new DecimalFormatSymbols();
		symb.setDecimalSeparator('.');
		df = new DecimalFormat("#.##", symb);
	}

	@Test
	/**
	 * First example of README.md
	 */
	public void testCaseOne() {
		/**
		 * 1 adult, 31 days to the departure date, flying AMS -> FRA
		 * 
		 * flights:
		 * 
		 * TK2372, 157.6 € TK2659, 198.4 € LH5909, 90.4 €
		 */
		FlightPriceConfig config = new FlightPriceConfig();
		config.setDaysToTheDeparture(31);
		config.setNumAdults(1);
		config.setOriginDestination("AMSFRA");

		List<SearcherResponse> responseList = flightSearcher.search(config);

		System.out.println("Result for case #1: ");
		for (SearcherResponse response : responseList) {
			System.out.println(response);
		}
		System.out.println("########################################################################");

		Assert.assertTrue(responseList.size() == 3);

		Assert.assertTrue(responseList.get(0).getAirline().equals("TK2372"));
		Assert.assertTrue(responseList.get(0).getPrintableTotalPrice().equals("157.6 €"));
		Assert.assertTrue(df.format(responseList.get(0).getTotalPrice()).equals("157.6"));

		Assert.assertTrue(responseList.get(1).getAirline().equals("TK2659"));
		Assert.assertTrue(responseList.get(1).getPrintableTotalPrice().equals("198.4 €"));
		Assert.assertTrue(df.format(responseList.get(1).getTotalPrice()).equals("198.4"));

		Assert.assertTrue(responseList.get(2).getAirline().equals("LH5909"));
		Assert.assertTrue(responseList.get(2).getPrintableTotalPrice().equals("90.4 €"));
		Assert.assertTrue(df.format(responseList.get(2).getTotalPrice()).equals("90.4"));
	}

	@Test
	/**
	 * Second example of README.md
	 */
	public void testCaseTwo() {
		/*
		 * 2 adults, 1 child, 1 infant, 15 days to the departure date, flying
		 * LHR -> IST
		 * 
		 * flights:
		 * 
		 * TK8891, 806 € (2 * (120% of 250) + 67% of (120% of 250) + 5) LH1085,
		 * 481.19 € (2 * (120% of 148) + 67% of (120% of 148) + 7)
		 */
		FlightPriceConfig config = new FlightPriceConfig();
		config = new FlightPriceConfig();
		config.setDaysToTheDeparture(15);
		config.setNumAdults(2);
		config.setNumChildren(1);
		config.setNumInfants(1);
		config.setOriginDestination("LHRIST");

		List<SearcherResponse> responseList = flightSearcher.search(config);

		System.out.println("Result for case #2: ");
		for (SearcherResponse response : responseList) {
			System.out.println(response);
		}
		System.out.println("########################################################################");

		Assert.assertTrue(responseList.size() == 2);

		Assert.assertTrue(responseList.get(0).getAirline().equals("TK8891"));
		Assert.assertTrue(responseList.get(0).getPrintableTotalPrice().equals("806 €"));
		Assert.assertTrue(df.format(responseList.get(0).getTotalPrice()).equals("806"));

		Assert.assertTrue(responseList.get(1).getAirline().equals("LH1085"));
		Assert.assertTrue(responseList.get(1).getPrintableTotalPrice().equals("481.19 €"));
		Assert.assertTrue(df.format(responseList.get(1).getTotalPrice()).equals("481.19"));

	}

	@Test
	/**
	 * Third example of README.md
	 */
	public void testCaseThree() {
		/**
		 * 1 adult, 2 children, 2 days to the departure date, flying BCN -> MAD
		 * 
		 * flights:
		 * 
		 * IB2171, 909.09 € (150% of 259 + 2 * 67% of (150% of 259)) 
		 * LH5496, 1028.43 € (150% of 293 + 2 * 67% of (150% of 293))
		 */
		FlightPriceConfig config = new FlightPriceConfig();
		config = new FlightPriceConfig();
		config.setDaysToTheDeparture(2);
		config.setNumAdults(1);
		config.setNumChildren(2);
		config.setOriginDestination("BCNMAD");

		List<SearcherResponse> responseList = flightSearcher.search(config);

		System.out.println("Result for case #3: ");
		for (SearcherResponse response : responseList) {
			System.out.println(response);
		}
		System.out.println("########################################################################");

		Assert.assertTrue(responseList.size() == 2);

		Assert.assertTrue(responseList.get(0).getAirline().equals("IB2171"));
		Assert.assertTrue(responseList.get(0).getPrintableTotalPrice().equals("909.09 €"));
		Assert.assertTrue(df.format(responseList.get(0).getTotalPrice()).equals("909.09"));

		Assert.assertTrue(responseList.get(1).getAirline().equals("LH5496"));
		Assert.assertTrue(responseList.get(1).getPrintableTotalPrice().equals("1028.43 €"));
		Assert.assertTrue(df.format(responseList.get(1).getTotalPrice()).equals("1028.43"));

	}
	
	@Test
	/**
	 * Forth example of README.md
	 */
	public void testCaseFour() {
		/**
		 * CDG -> FRA

  			no flights available
		 */
		FlightPriceConfig config = new FlightPriceConfig();
		config = new FlightPriceConfig();
		config.setOriginDestination("CDGFRA");

		List<SearcherResponse> responseList = flightSearcher.search(config);

		Assert.assertTrue(responseList.isEmpty());

	}
}
