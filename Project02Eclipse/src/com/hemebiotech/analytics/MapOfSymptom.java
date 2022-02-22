package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Class for counting and writing in a file a list of symptoms strings
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

	/**
	 * 
	 * @param filepath a full or partial path to file
	 */
	public void WriteSymptomstoFile(String outputFile) {
		try {
			FileWriter writer = new FileWriter(outputFile);
			try {
				for (Map.Entry<String, Integer> entry : this.entrySet()) {
					System.out.println(entry.getKey() + ": " + entry.getValue());
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
				}
			} catch (IOException e) {
				System.out.println("Problème écriture fichier de sortie");
				e.printStackTrace();
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Problème ouverture fichier de sortie");
			e.printStackTrace();
		}
	}

}
