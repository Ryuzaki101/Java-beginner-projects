package de.hsma.java.kapitel6;

import java.io.IOException;

/** 
 * Das Programm liest die Eingaben über den Standard
 * Eingabe zeilenweise ein und gibt sie über die 
 * Standard Ausgabe wieder aus, bis der Text "Exit" 
 * vom Benutzer eingegeben wird.
 * Dann terminiert das Programm.
 */
public class EchoInput {

	public static void main (String[] args)  {

		final int BUF_LEN = 80;				// Maximale Länge des Puffers
		byte buffer[] = new byte[BUF_LEN]; 	// Eingabe Puffer
		String inString = "";				// Eingelesene Zeile

		System.out.println("Geben Sie Text ein");
		System.out.println("Die Eingabe von \"Exit\" beendet das Programm");

		do {
			try {
				// Eine Zeile Text (Abgeschlossen durch Return) lesen und in Puffer abspeichern
				int read = System.in.read(buffer, 0, BUF_LEN);	// Blockiert bis Zeilende

				// Eingabe Puffer in String konvertieren
				inString = new String(buffer,0,read);

				// Eingelesenen String wieder ausgeben, 
				// wenn es sich nicht um den Terminierungs-String handelt
				if(!inString.trim().equals("Exit"))	
					System.out.print(inString);		// Hier verwenden wir print() und nicht println(), 
													// da das Steuerzeichen "neue Zeile" bereits im String enthalten ist.

			} catch (IOException e) {
				System.out.println("Exception: " + e.getMessage());
			}

		// Schleife so lange durchlafen, bis Exit eingegeben wurde
		} while (!inString.trim().equals("Exit"));		// Die trim()-Methode entfernt alle "White Spaces" (Normierung des Strings)
	}
}