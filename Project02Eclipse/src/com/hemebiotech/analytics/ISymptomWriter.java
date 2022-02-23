package com.hemebiotech.analytics;

/**
 * Anything that will write a MapOfSymptom to a output
 * 
 */
public interface ISymptomWriter {
	/**
	 * If map is empty, write nothing
	 * 
	 * @param the instance of the MapOfSymptom to write
	 */
	void WriteSymptoms(MapOfSymptom map) throws Exception;
}
