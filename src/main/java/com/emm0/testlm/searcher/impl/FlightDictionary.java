package com.emm0.testlm.searcher.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emm0.testlm.model.Flight;

/**
 * This class loads and stores a dictionary of flights
 * @author emp
 *
 */
public class FlightDictionary {
	
	private static final String FLIGHT_FILE_NAME = "flights.csv";
	private static final String CVS_SPLIT_BY = ",";
	
	private static final int COLUMN_ORIGIN = 0;
	private static final int COLUMN_DESTINATION = 1;
	private static final int COLUMN_AIRLINE = 2;
	private static final int COLUMN_BASE_PRICE = 3;
	
	/**
	 * Map with the flights the key is origin.concat(destination)
	 */
	private Map<String, List<Flight>> flightMap = new HashMap<>();
	
	/**
	 * This constructor loads the flights from a CSV file
	 */
	public FlightDictionary(){
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = CVS_SPLIT_BY;

        try {
        	
        	ClassLoader classLoader = getClass().getClassLoader();

            br = new BufferedReader(new FileReader(classLoader.getResource(FLIGHT_FILE_NAME).getFile()));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] items = line.split(cvsSplitBy);
                
                //We read the values from the file and then create a flight and save it into flightMap
                try{
                	
                	Flight flight = new Flight(items[COLUMN_ORIGIN], items[COLUMN_DESTINATION], items[COLUMN_AIRLINE], Double.valueOf(items[COLUMN_BASE_PRICE]));
                	
                	String key = items[COLUMN_ORIGIN].concat(items[COLUMN_DESTINATION]);
                	
                	List<Flight> flightList = flightMap.get(key);
                	if (flightList == null){
                		flightList = new ArrayList<>();
                		flightMap.put(key, flightList);
                	}
                	
                	flightList.add(flight);
                	
                }catch(NumberFormatException e){
                	e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Returns a list of flights given a origin+destination
	 * Search Complexity: Constant
	 * @param key origin+destination
	 * @return a list of flights
	 */
	public List<Flight> getFlights(String key){
		
		//if null we return empty List
		return flightMap.get(key) != null ? flightMap.get(key) : new ArrayList<Flight>();
	}

}
