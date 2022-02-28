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

		final String NAMEOFINPUTFILE = "Project02Eclipse/symptoms.txt";
		final String NAMEOFOUTPUTFILE = "Project02Eclipse/result.out";

		try {
			// Chargement du fichier sous forme de liste
			ISymptomReader symptomReader = new ReadSymptomDataFromFile(NAMEOFINPUTFILE);
			List<String> listOfSymptoms = symptomReader.GetSymptoms();

			// Remplissage de la Map à partir de la liste contenant les symptômes et
			// comptage
			MapOfSymptom mapOfSymptoms = new MapOfSymptom();
			mapOfSymptoms.CountSymptoms(listOfSymptoms);

			// Ecriture de la Map dans le fichier de sortie
			ISymptomWriter symptomWriter = new WriteSymptomDataToFile(NAMEOFOUTPUTFILE);
			symptomWriter.WriteSymptoms(mapOfSymptoms);
			System.out
					.println("Fin traitement : " + mapOfSymptoms.size() + " symptômes écrits dans " + NAMEOFOUTPUTFILE);
		} catch (Exception e) {
			System.out.println("Anomalie lors de l'exécution : " + e.getMessage());
		}
	}
}
