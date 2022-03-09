package com.hemebiotech.analytics;

/**
 * Anything that will write a MapOfSymptom to a output
 * 
 */
public interface ISymptomWriter {
	/**
	 * @param map : Map of Symptoms to write to
	 * @throws Exception in case of issues to write in the file or if map is empty
	 */
	void writeSymptoms(MapOfSymptom map) throws Exception;
}
