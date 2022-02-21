package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {
		// first get input
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));

			try {

				String line = reader.readLine();

				while (line != null) {
					System.out.println("symptom from file: " + line);
					if (line.equals("headache")) {
						headacheCount++;
						System.out.println("number of headaches: " + headacheCount);
					} else if (line.equals("rash")) {
						rashCount++;
					} else if (line.contains("pupils")) {
						pupilCount++;
					}

					line = reader.readLine(); // get another symptom
				}
			} catch (IOException e) {
				System.out.println("Problème lecture fichier");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier en entrée non trouvé");
		}
		// next generate output
		try {
			FileWriter writer = new FileWriter("Project02Eclipse/result.out");
			try {
				writer.write("headache: " + headacheCount + "\n");
				writer.write("rash: " + rashCount + "\n");
				writer.write("dialated pupils: " + pupilCount + "\n");
			} catch (IOException e) {
				System.out.println("Problème écriture fichier de sortie");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Problème ouverture fichier de sortie");
		}

	}
}
