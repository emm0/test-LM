package com.emm0.testlm.searcher.api;

import java.util.List;

import com.emm0.testlm.model.SearcherResponse;

/**
 * This interface represents the main module of the test, the searcher 
 * @author emp
 *
 */
public interface FlightSearcher {
	
	/**
	 * Given a FlightPriceConfig search the flights and calculate the total price
	 * @param config
	 * @return
	 */
	List<SearcherResponse> search(FlightPriceConfig config);

}
