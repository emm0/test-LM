package com.emm0.testlm.calculator.api;

import com.emm0.testlm.model.Flight;
import com.emm0.testlm.searcher.api.FlightPriceConfig;

/**
 * This interface represents a calculator that calculates the total price
 * @author emp
 *
 */
public interface FlightPriceCalculator {
	
	/**
	 * calculates the total price given a flightPriceConfig and a flight
	 * @param flightPriceConfig Configuration for the flight
	 * @param flight flight info
	 * @return the total price
	 * @throws NonInfantPriceException indicates that the airline doesn't have price for infants
	 */
	double calculatePrice(FlightPriceConfig flightPriceConfig, Flight flight)  throws NonInfantPriceException; 

}
