package de.hsma.java.kapitel8;

import java.io.*;
import java.net.*;

/** 
 * Demonstriert die Benutzung einer URL
 * um eine Datei aus dem Netzwerk zu laden
 * 
 * z.B. http://www.swt.hs-mannheim.de
 * 
 */
public class PrintURL {
	
	public static void main(String[] args) {
		String thisLine;

		if (args.length != 1){ 
			System.out.println("Using: java PrintURL <url>");
			System.exit(1);
		}		
		
		System.out.println("Verbindungsversuch zu " + args[0]);
		
		try {
			// Eingegebene Adresse in URL-Objekt kapseln, mittels openStream() einen InputStream erzeugen
			// und über das ganze einen BufferedReader stülpen
			BufferedReader in = new BufferedReader(new InputStreamReader((new URL(args[0])).openStream()));
			System.out.println("Verbunden");
			
			try {
				// über den BufferedReader die komplette Datei lesen, welche sich hinter der Adresse verbirgt
				while ((thisLine = in.readLine()) != null) 
					System.out.println(thisLine);
				
				in.close();
				System.out.println("Verbindung geschlossen");
				
			} catch (Exception e) {
				System.out.println("Lesefehler: " + e);
			}
		} catch (Exception e) {
			System.out.println("Verbindungsfehler: " + e);
		}
	}
}