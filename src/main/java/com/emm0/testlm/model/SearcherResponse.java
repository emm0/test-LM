package com.emm0.testlm.model;

public class SearcherResponse {
	
	private String airline;
	
	private Double totalPrice;
	
	private String printableTotalPrice;

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
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the printableTotalPrice
	 */
	public String getPrintableTotalPrice() {
		return printableTotalPrice;
	}

	/**
	 * @param printableTotalPrice the printableTotalPrice to set
	 */
	public void setPrintableTotalPrice(String printableTotalPrice) {
		this.printableTotalPrice = printableTotalPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearcherResponse [airline=" + airline + ", totalPrice=" + totalPrice + ", printableTotalPrice="
				+ printableTotalPrice + "]";
	}

}
