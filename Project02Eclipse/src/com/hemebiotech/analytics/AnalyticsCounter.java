package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

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
			System.out.println("Le traitement s'est exécuté correctement");
		} catch (Exception e) {
			System.out.println("Anomalie lors de l'exécution : " + e.getMessage());
		}
	}
}
