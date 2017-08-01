package com.emm0.testlm.calculator.impl;

import java.util.HashMap;
import java.util.Map;

import com.emm0.testlm.calculator.api.FlightPriceCalculator;
import com.emm0.testlm.calculator.api.NonInfantPriceException;
import com.emm0.testlm.model.Flight;
import com.emm0.testlm.searcher.api.FlightPriceConfig;

/**
 * Implementation of FlightPriceCalculator
 * @author emp
 *
 */
public class FlightPriceCalculatorImpl implements FlightPriceCalculator {

	// 33% discount for children
	private static final double CHILDREN_DISCOUNT = 0.33;
	
	/**
	 * Table with infant price by airline
	 */
	Map<String, Double> infantPriceMap = new HashMap<>();
	
	/**
	 * Constructor
	 */
	public FlightPriceCalculatorImpl(){
		
		loadInfantPriceMap();
	}
	
	@Override
	public double calculatePrice(FlightPriceConfig flightPriceConfig, Flight flight) throws NonInfantPriceException {
		
		int daysToDeparture = flightPriceConfig.getDaysToTheDeparture();
		/*| days prior to the departure date | % of the base price |
		|----------------------------------|---------------------|
		| more than 30 (i.e. >= 31)        | 80%                 |
		| 30 - 16                          | 100%                |
		| 15 - 3                           | 120%                |
		| less that 3 (i.e. <= 2)          | 150%                |*/
		double daysToDepartureDateFactor = daysToDeparture >= 31 ? 0.8 : 
										   daysToDeparture <= 30 && daysToDeparture >= 16 ? 1 :
										   daysToDeparture <= 15 && daysToDeparture >= 3 ? 1.2 :
										   daysToDeparture <= 2 ? 1.5 : 1;
										   
		double basePrice = flight.getBasePrice();
		
		/*| passenger type | price                                                                                          |
		|----------------|------------------------------------------------------------------------------------------------|
		| adult          | full price (i.e. price resulting from the *days to departure date* rule)                       |
		| child          | 33% discount of the price calculated according to the *days to departure date* rule            |
		| infant         | fixed price depending on the airline. Rule *days to departure date* is not applied for infants |*/
		
		double price = flightPriceConfig.getNumAdults() * basePrice * daysToDepartureDateFactor;
		
		price += flightPriceConfig.getNumChildren() * basePrice * daysToDepartureDateFactor * (1-CHILDREN_DISCOUNT); 
		
		if (flightPriceConfig.getNumInfants() > 0){
			Double infantPrice = infantPriceMap.get(flight.getAirline().substring(0, 2));
			
			if (infantPrice != null){
				price += flightPriceConfig.getNumInfants() * infantPrice;
			}else{
				throw new NonInfantPriceException();
			}
			
		}
		
		return price;
	}
	
	/**
	 * We load the prices for infants
	 */
	private void loadInfantPriceMap(){
		/*| IATA code | name             | infant price |
		|-----------|------------------|--------------|
		| IB        | Iberia           | 10 €         |
		| BA        | British Airways  | 15 €         |
		| LH        | Lufthansa        | 7 €          |
		| FR        | Ryanair          | 20 €         |
		| VY        | Vueling          | 10 €         |
		| TK        | Turkish Airlines | 5 €          |
		| U2        | Easyjet          | 19.90 €      |*/
		infantPriceMap.put("IB", 10.0);
		infantPriceMap.put("BA", 15.0);
		infantPriceMap.put("LH", 7.0);
		infantPriceMap.put("FR", 20.0);
		infantPriceMap.put("VY", 10.0);
		infantPriceMap.put("TK", 5.0);
		infantPriceMap.put("U2", 19.9);
	}

}
