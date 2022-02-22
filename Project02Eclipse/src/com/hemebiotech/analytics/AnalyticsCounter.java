package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		final String NAMEOFINPUTFILE = "Project02Eclipse/symptoms.txt";
		final String NAMEOFOUTPUTFILE = "Project02Eclipse/result.out";

		// Chargement du fichier sous forme de liste
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(NAMEOFINPUTFILE);
		List<String> listOfSymptoms = symptomReader.GetSymptoms();

		// Instanciation et remplissage de la Map contenant les symptômes
		MapOfSymptom mapOfSymptoms = new MapOfSymptom();
		mapOfSymptoms.CountSymptoms(listOfSymptoms);

		// Ecriture de la Map dans le fichier de sortie
		mapOfSymptoms.WriteSymptomstoFile(NAMEOFOUTPUTFILE);

	}
}
