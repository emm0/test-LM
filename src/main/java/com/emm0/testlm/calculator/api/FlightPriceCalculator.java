package com.emm0.testlm.calculator.api;

import com.emm0.testlm.model.Flight;
import com.emm0.testlm.searcher.api.FlightPriceConfig;

public interface FlightPriceCalculator {
	
	double calculatePrice(FlightPriceConfig flightPriceConfig, Flight flight)  throws NonInfantPriceException; 

}
