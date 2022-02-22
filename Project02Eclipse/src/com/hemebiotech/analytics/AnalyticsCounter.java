package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		final String NAMEOFINPUTFILE = "Project02Eclipse/symptoms.txt";
		final String NAMEOFOUTPUTFILE = "Project02Eclipse/result.out";

		// Chargement du fichier sous forme de liste
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(NAMEOFINPUTFILE);
		List<String> listOfSymptoms = symptomReader.GetSymptoms();

		// Remplissage de la TreeMap
		Map<String, Integer> mapOfSymptoms = new TreeMap<String, Integer>();

		Integer count;
		for (String list : listOfSymptoms) {
			if (mapOfSymptoms.containsKey(list)) {
				count = mapOfSymptoms.get(list) + 1;
			} else {
				count = 1;
			}
			mapOfSymptoms.put(list, count);
		}

		// Ecriture de la TreeMap dans le fichier de sortie

		try {
			FileWriter writer = new FileWriter(NAMEOFOUTPUTFILE);
			try {
				for (Map.Entry<String, Integer> entry : mapOfSymptoms.entrySet()) {
					System.out.println(entry.getKey() + ": " + entry.getValue());
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
				}
			} catch (IOException e) {
				System.out.println("Problème écriture fichier de sortie");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Problème ouverture fichier de sortie");
		}

	}
}
