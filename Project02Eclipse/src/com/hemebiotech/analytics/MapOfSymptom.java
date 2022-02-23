package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * 
 * Class to convert a list of symptoms strings in a map
 */

public class MapOfSymptom extends TreeMap<String, Integer> {

	static final long serialVersionUID = 1;

	/**
	 * 
	 * @param list of symptoms strings
	 */
	public void CountSymptoms(List<String> listOfSymptoms) {

		Integer count;
		for (String list : listOfSymptoms) {
			if (this.containsKey(list)) {
				count = this.get(list) + 1;
			} else {
				count = 1;
			}
			this.put(list, count);
		}
	}

}
