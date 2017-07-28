package com.emm0.testlm.model;

/**
 * This class models a flight
 * @author emp
 *
 */
public class Flight {

	/**
	 * Origin property
	 */
	private String origin;
	
	/**
	 *  Destination property
	 */
	private String destination;
	
	/**
	 * AirLine property
	 */
	private String airline;
	
	/**
	 * base price property
	 */
	private double basePrice;

	/**
	 * Constructor
	 * @param origin
	 * @param destination
	 * @param airline
	 * @param basePrice
	 */
	public Flight(String origin, String destination, String airline, double basePrice) {
		this.origin = origin;
		this.destination = destination;
		this.airline = airline;
		this.basePrice = basePrice;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * @return the basePrice
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight [origin=" + origin + ", destination=" + destination + ", airline=" + airline + ", basePrice="
				+ basePrice + "]";
	}
	
	
}
