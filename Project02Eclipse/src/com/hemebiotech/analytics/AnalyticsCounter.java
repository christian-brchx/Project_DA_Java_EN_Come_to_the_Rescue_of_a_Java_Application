package com.hemebiotech.analytics;

import java.util.List;

/**
 * 
 * Class entry of the program
 */
public class AnalyticsCounter {

	/**
	 * 
	 * @param args not used
	 */
	public static void main(String args[]) {

		final String NAME_OF_INPUT_FILE = "Project02Eclipse/symptoms.txt";
		final String NAME_OF_OUTPUT_FILE = "Project02Eclipse/result.out";

		try {
			// Chargement du fichier sous forme de liste
			ISymptomReader symptomReader = new ReadSymptomDataFromFile(NAME_OF_INPUT_FILE);
			List<String> listOfSymptoms = symptomReader.getSymptoms();

			// Remplissage de la Map à partir de la liste contenant les symptômes et
			// comptage
			MapOfSymptom mapOfSymptoms = new MapOfSymptom();
			mapOfSymptoms.CountSymptoms(listOfSymptoms);

			// Ecriture de la Map dans le fichier de sortie
			ISymptomWriter symptomWriter = new WriteSymptomDataToFile(NAME_OF_OUTPUT_FILE);
			symptomWriter.writeSymptoms(mapOfSymptoms);
			System.out
					.println("Fin traitement : " + mapOfSymptoms.size() + " symptômes écrits dans "
							+ NAME_OF_OUTPUT_FILE);
		} catch (Exception e) {
			System.err.println("Anomalie lors de l'exécution : " + e.getMessage());
		}
	}
}
