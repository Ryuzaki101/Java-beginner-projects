package de.hsma.java.kapitel6;

import java.io.*;

/** 
 * Das Programm liest int-Zahlen 
 * von der Standard Eingabe ein 
 * und speichert sie im Binärformat
 * in einer Datei ab.
 * Der Dateiname wird als Kommando-
 * zeilenargument eingegeben.
 */
public class IntWriter {

	@SuppressWarnings("deprecation")
	public static void main (String[] args)  {

		DataInputStream dis = null;   	// Input Filter
		DataOutputStream dos = null;  	// Output Filter
		int number = 0;					// eingelesene Zahl

		if (args.length != 1) {
			System.out.println("Using: java IntWriter <filename>");
			return;
		}

		System.out.println("Positive Integer Zahlen eingeben");
		System.out.println("Die Eingabe von -1 beendet das Programm");

		// DataInputStream über Standard Eingabe stülpen
		dis = new DataInputStream(System.in); 

		try {
			// Ausgabe-Datei erzeugen und DataOutputStream darüber legen
			dos = new DataOutputStream(new FileOutputStream(args[0]));

			do {
				// Eingegebene Zahl lesen
				String inString = dis.readLine();   // Deprecated, es sollte BufferedReader genutzt werden (Kapitel 6.4)

				// Text in Zahl konvertieren
				number = Integer.valueOf(inString);

				if (number != -1)
					// Zahl in Datei speichern, wenn es sich nicht um die Terminierungseingabe handelt
					dos.writeInt(number);

			} while (number != -1);  // Schleife abbrechen, wenn -1 eingegeben wurde

		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			// Die Ausgabedatei wird unabhängig von evtl. aufgetretenen Exceptions geschlossen.
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}