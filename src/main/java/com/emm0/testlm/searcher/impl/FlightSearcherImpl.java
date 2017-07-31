package com.emm0.testlm.searcher.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import com.emm0.testlm.calculator.api.FlightPriceCalculator;
import com.emm0.testlm.calculator.api.NonInfantPriceException;
import com.emm0.testlm.calculator.impl.FlightPriceCalculatorImpl;
import com.emm0.testlm.model.Flight;
import com.emm0.testlm.model.SearcherResponse;
import com.emm0.testlm.searcher.api.FlightPriceConfig;
import com.emm0.testlm.searcher.api.FlightSearcher;

public class FlightSearcherImpl implements FlightSearcher {
	
	private static final String NON_INFANT_ERROR = "Error: no fare available for infant";

	/**
	 * formatter to format 2 decimal number
	 */
	DecimalFormat df;
	
	/**
	 * Contains all the flights
	 */
	FlightDictionary fDictionary = new FlightDictionary();
	
	/**
	 * We use this to calculate the price
	 */
	FlightPriceCalculator calculator = new FlightPriceCalculatorImpl();
	
	/**
	 * Constructor
	 */
	public FlightSearcherImpl(){
		
		DecimalFormatSymbols symb = new DecimalFormatSymbols();
		symb.setDecimalSeparator('.');
		df = new DecimalFormat("#.## €", symb);
	}
	
	@Override
	public List<SearcherResponse> search(FlightPriceConfig config) {
		
		List<Flight> flights = fDictionary.getFlights(config.getOriginDestination());
		
		List<SearcherResponse> responseList = new ArrayList<>();
		
		for (Flight f : flights){
			SearcherResponse response = new SearcherResponse();
			
			response.setAirline(f.getAirline());
			
			double totalPrice = 0.0;
			String printableTotalPrice = "";
			
			try {
				totalPrice = calculator.calculatePrice(config, f);
				printableTotalPrice = df.format(totalPrice);
			} catch (NonInfantPriceException e) {
				e.printStackTrace();
				printableTotalPrice = NON_INFANT_ERROR;
			}
			
			response.setTotalPrice(totalPrice);
			response.setPrintableTotalPrice(printableTotalPrice);
			
			responseList.add(response);
		}
		
		return responseList;
	}

}
