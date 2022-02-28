package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Write Symptoms and counts to a file
 *
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file to write to
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void WriteSymptoms(MapOfSymptom map) throws Exception {
		if ((filepath != null) && (map.size()) > 0) {
			try {
				FileWriter writer = new FileWriter(filepath);
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
				}
				writer.close();
			} catch (IOException e) {
				throw new Exception("Problème écriture fichier de sortie" + filepath);
			}
		}
	}

}
