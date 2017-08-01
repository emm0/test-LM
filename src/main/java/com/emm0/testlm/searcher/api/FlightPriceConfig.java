package com.emm0.testlm.searcher.api;

/**
 * Represents a config for the flightSearcher 
 * @author emp
 *
 */
public class FlightPriceConfig {
	
	/**
	 * Days to the departure property
	 */
	private int daysToTheDeparture;
	
	/**
	 * Number of Adults property
	 */
	private int numAdults = 0;
	
	/**
	 * Number of children property
	 */
	private int numChildren = 0;
	
	/**
	 * Number of infants property
	 */
	private int numInfants = 0;
	
	/**
	 * Origin and destination property (Concatenated)
	 */
	String originDestination;

	/**
	 * @return the daysToTheDeparture
	 */
	public int getDaysToTheDeparture() {
		return daysToTheDeparture;
	}

	/**
	 * @param daysToTheDeparture the daysToTheDeparture to set
	 */
	public void setDaysToTheDeparture(int daysToTheDeparture) {
		this.daysToTheDeparture = daysToTheDeparture;
	}

	/**
	 * @return the numAdults
	 */
	public int getNumAdults() {
		return numAdults;
	}

	/**
	 * @param numAdults the numAdults to set
	 */
	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}

	/**
	 * @return the numChildren
	 */
	public int getNumChildren() {
		return numChildren;
	}

	/**
	 * @param numChildren the numChildren to set
	 */
	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	/**
	 * @return the numInfants
	 */
	public int getNumInfants() {
		return numInfants;
	}

	/**
	 * @param numInfants the numInfants to set
	 */
	public void setNumInfants(int numInfants) {
		this.numInfants = numInfants;
	}

	/**
	 * @return the originDestination
	 */
	public String getOriginDestination() {
		return originDestination;
	}

	/**
	 * @param originDestination the originDestination to set
	 */
	public void setOriginDestination(String originDestination) {
		this.originDestination = originDestination;
	}
	

}
