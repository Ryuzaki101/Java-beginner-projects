package de.hsma.java.kapitel6;

import java.io.*;

/** 
 * Das Programm liest die Eingaben über den Standard
 * Eingabe zeilenweise ein und gibt sie über die 
 * Standard Ausgabe wieder aus, bis der Text "Exit" 
 * vom Benutzer eingegeben wird.
 * Dann terminiert das Programm.
 * 
 * Dazu wird ein BufferedReader zum lesen
 * und ein PrintWriter zum schreiben genutzt.
 */
public class EchoInput {
	public static void main (String[] args)  {
		String inString = "";
		
		System.out.println("Geben Sie Text ein");
		System.out.println("Die Eingabe von \"Exit\" beendet das Programm");

		try {
			// BufferedReader über System.in stülpen
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			
			// PrintWriter über System.out stülpen
			PrintWriter pw = new PrintWriter(System.out,true); // automatic flush aktivieren

			do {
				// Textzeile lesen
				inString = br.readLine();
				
				// Textzeile wieder ausgeben
				if(!inString.equals("Exit"))
					pw.println(inString);
				
			// Bei der Eingabe von "Exit" terminieren
			} while(!inString.equals("Exit"));
			
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
